package com.theplayer.service;

import com.theplayer.entity.UserEntity;

public interface IUserService extends AbstractService<UserEntity>{
	UserEntity findOneByAccountId(Long id);
}
