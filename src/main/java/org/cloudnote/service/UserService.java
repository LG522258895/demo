package org.cloudnote.service;

import org.cloudnote.core.exception.OMException;
import org.cloudnote.entity.User;

public interface UserService {
	public String userLogin(User user) throws OMException;
}
