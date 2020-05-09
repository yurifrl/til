package test.java.com.app;

import main.java.com.app.App;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

public class AppTest extends TestCase {
  public void testMainCall() {
    App.main(new String[] { });
  }
}
