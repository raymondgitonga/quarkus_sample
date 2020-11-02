package com.tosh.quarkus_sample;

import io.quarkus.test.junit.NativeImageTest;

@NativeImageTest
public class NativeUserResourceIT extends UserResourceTest {

    // Execute the same tests but in native mode.
}