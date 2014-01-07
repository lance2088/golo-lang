package org.gololang.microbenchmarks.support;

import org.junit.Test;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodType;

import static java.lang.invoke.MethodType.genericMethodType;
import static org.junit.Assert.assertEquals;

public class CodeLoaderTest {

  @Test
  public void test_golo_loading() throws Throwable {
    CodeLoader loader = new CodeLoader();

    MethodHandle truth = loader.golo("check", "truth", 0);
    assertEquals(42, (Object) truth.invokeExact());

    MethodHandle incr = loader.golo("check", "incr", 1);
    assertEquals(42, (Object) incr.invokeExact((Object) 41));
  }

  @Test
  public void test_groovy_loading() throws Throwable {
    CodeLoader loader = new CodeLoader();

    MethodHandle truth = loader.groovy("Check", "truth", genericMethodType(0));
    assertEquals(42, (Object) truth.invokeExact());

    MethodHandle incr = loader.groovy("Check", "incr", genericMethodType(1));
    assertEquals(42, (Object) incr.invokeExact((Object) 41));
  }

  @Test
  public void test_groovy_indy_loading() throws Throwable {
    CodeLoader loader = new CodeLoader();

    MethodHandle truth = loader.groovy_indy("Check", "truth", genericMethodType(0));
    assertEquals(42, (Object) truth.invokeExact());

    MethodHandle incr = loader.groovy_indy("Check", "incr", genericMethodType(1));
    assertEquals(42, (Object) incr.invokeExact((Object) 41));
  }
}
