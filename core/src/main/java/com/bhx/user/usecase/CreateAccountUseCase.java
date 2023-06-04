package com.bhx.user.usecase;

import com.bhx.product.Product;
import com.bhx.product.exception.ProductAlreadyExistException;
import com.bhx.user.Account;
import com.bhx.user.exception.AccountAlreadyExistException;

/**
 * @author "KhaPhan" on 20-May-23
 */
public interface CreateAccountUseCase {
    void execute(Account account) throws AccountAlreadyExistException;
}
