package com.backend.desafio.picpay.transaction;

import com.backend.desafio.picpay.authorization.AuthorizerService;
import com.backend.desafio.picpay.notification.NotificationService;
import com.backend.desafio.picpay.wallet.Wallet;
import com.backend.desafio.picpay.wallet.WalletRepository;
import com.backend.desafio.picpay.wallet.WalletType;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class TransactionService {
    private final TransactionRepository transactionRepository;
    private final WalletRepository walletRepository;
    private final AuthorizerService authorizerService;
    private final NotificationService notificationService;

    public TransactionService(TransactionRepository transactionRepository, WalletRepository walletRepository, AuthorizerService authorizerService, NotificationService notificationService) {
        this.transactionRepository = transactionRepository;
        this.walletRepository = walletRepository;
        this.authorizerService = authorizerService;
        this.notificationService = notificationService;
    }

    @Transactional
    public Transaction create(Transaction transaction) {
        validate(transaction);
        var newTransaction = transactionRepository.save(transaction);

        var walletPayer = walletRepository.findById(transaction.payer()).get();
        walletRepository.save(walletPayer.debit(transaction.value()));

        var walletPayee = walletRepository.findById(transaction.payee()).get();
        walletRepository.save(walletPayee.credit(transaction.value()));

        notificationService.notify(transaction);

        authorizerService.authorize(transaction);

        return newTransaction;
    }

    private void validate(Transaction transaction) {
        walletRepository.findById(transaction.payee())
                .map(payee -> walletRepository.findById(transaction.payer())
                        .map(payer -> isTransactionValid(transaction, payer) ? transaction : null)
                        .orElseThrow(() -> new InsufficientTransactionBalanceException("Insufficient balance to complete the transaction. - %s".formatted(transaction))))
                .orElseThrow(() -> new InvalidTransactionException("Invalid transaction - %s".formatted(transaction)));

    }

    private boolean isTransactionValid(Transaction transaction, Wallet payer) {
        return payer.type() == WalletType.COMUN.getValue() &&
                payer.balance().compareTo(transaction.value()) >= 0 &&
                !payer.id().equals(transaction.payee());
    }

    public List<Transaction> list() {
        return transactionRepository.findAll();
    }
}
