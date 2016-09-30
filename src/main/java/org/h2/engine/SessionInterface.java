/*
 * Copyright 2004-2014 H2 Group. Multiple-Licensed under the MPL 2.0,
 * and the EPL 1.0 (http://h2database.com/html/license.html).
 * Initial Developer: H2 Group
 */
package org.h2.engine;

import java.io.Closeable;
import java.io.IOException;
import java.util.ArrayList;

/**
 * A local or remote session. A session represents a database connection.
 * */
public interface SessionInterface extends Closeable{
	
	/**
	 * Get the list of the cluster servers for this session.
	 * 
	 * @return A list of "ip:port" strings for the cluster servers in this session.
	 * 
	 * 세션에 속한 클러스터를 구성하고 있는 서버들의 리스트를 리턴한다.
	 * */
	ArrayList<String> getClusterServers();
	
	/**
	 * Roll back pending transations and close the session.
	 * 아직 세션안에서 처리가 안된(보류) 트랜젝션들을 롤백시키고 세션을 닫는다.
	 * try{} 안에서 자동으로 자원(세션)을 종료하기위해 SessionInterface를 구현하는 클래스에서
	 * 구현해준다.
	 * */
	@Override
	void close();

	
	
}
