package com.wiley.internal.apps.service;

import java.util.List;

public interface UserAuthService {

	List<String> getByUsername(String username);

}
