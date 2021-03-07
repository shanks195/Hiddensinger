package com.theplayer.service;

import com.theplayer.entity.AccountEntity;

public interface IAccountService extends AbstractService<AccountEntity>{
	Long findIdAccountByUserName(String username);
	AccountEntity findById(Long id);
	AccountEntity findOneByUsername(String username);
}
