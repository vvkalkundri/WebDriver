package com.microsoft.sso.page;

import junit.framework.Test;

public interface Page extends Test{

	public void open() throws InterruptedException;

	public void close();

	public void getTitle();
}
