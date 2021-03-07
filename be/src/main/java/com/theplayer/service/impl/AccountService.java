package com.theplayer.service.impl;


import com.theplayer.entity.AccountEntity;
import com.theplayer.repository.AccountRepository;
import com.theplayer.service.IAccountService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class AccountService implements IAccountService{
    @Autowired private AccountRepository accountRepository;
    
    @Override
    public Long findIdAccountByUserName(String username){
       return accountRepository.findOneByUsername(username).getId();
    }
    
	@Override
	public AccountEntity save(AccountEntity entity) {
		// TODO Auto-generated method stub
		return accountRepository.save(entity);
	}
	@Override
	public List<AccountEntity> findAll(Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public int totalItem() {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public List<AccountEntity> findAll() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public void delete(long[] ids) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public AccountEntity findById(Long id) {
		// TODO Auto-generated method stub
		return accountRepository.findOneById(id);
	}

	@Override
	public AccountEntity findOneByUsername(String username) {
		// TODO Auto-generated method stub
		return accountRepository.findOneByUsername(username);
	} 
}
