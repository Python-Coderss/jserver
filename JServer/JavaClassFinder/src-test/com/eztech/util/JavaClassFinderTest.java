package com.eztech.util;

import java.io.FileFilter;
import java.util.List;

import junit.framework.TestCase;
import test.classes.MyTagInterface;

public class JavaClassFinderTest extends TestCase {

	private String myClassPath;
	private String originalClassPath;
	private String originalCustomClassPath;
	private JavaClassFinder classFinder;

	@Override
	protected void setUp() throws Exception {
		myClassPath = FileUtils.determineClassPathBase(this.getClass());
		classFinder = new JavaClassFinder();
		originalClassPath = System.getProperty("java.class.path");
		originalCustomClassPath = System.getProperty(JavaClassFinder.CUSTOM_CLASS_PATH_PROPERTY);
		if (originalCustomClassPath != null) {
			System.out.println("custom classpath was already set to=" + originalCustomClassPath);
		}
		System.out.println("original classpath=" + originalClassPath);
	}

	@Override
	protected void tearDown() throws Exception {
		System.setProperty("java.class.path", originalClassPath);
		if (originalCustomClassPath != null) {
			System.setProperty(JavaClassFinder.CUSTOM_CLASS_PATH_PROPERTY, originalCustomClassPath);
			System.out.println("custom classpath sysproperty reset to=" + originalCustomClassPath);
		} else {
			System.out.println("original custom classpath sysproperty was blank, clearing any custom classpath value value set in tests");
			System.clearProperty(JavaClassFinder.CUSTOM_CLASS_PATH_PROPERTY);
		}
		// System.getProperties().remove(JavaClassFinder.CUSTOM_CLASS_PATH_PROPERTY);
	}

	public void testFindExpectedJavaClassFilesForOneFile() throws Throwable {
		List<Class<? extends MyTagInterface>> classes = classFinder.findAllMatchingTypes(MyTagInterface.class);
		assertEquals("found the class", 3, classes.size());

	}

	public void testFindSubclassesClasses() throws Exception {
		Class<FileWalker> toMatch = FileWalker.class;
		String classPathRoot = FileUtils.determineClassPathBase(toMatch);
		System.setProperty("custom.class.path", classPathRoot);
		List<Class<? extends FileWalker>> classes = classFinder.findAllMatchingTypes(toMatch);
		assertEquals("found the subclasses of " + toMatch, 2, classes.size());
		assertTrue(classes.contains(JavaClassFileWalker.class));
		assertTrue(classes.contains(FileWalker.class));

		assertTrue(FileFilter.class.isAssignableFrom(JavaClassFileFilter.class));
	}

	public void testAbilityToUseCustomClassPathProperty() throws Exception {
		Class<FileWalker> toMatch = FileWalker.class;
		String classPathRoot = FileUtils.determineClassPathBase(toMatch);
		System.setProperty(JavaClassFinder.CUSTOM_CLASS_PATH_PROPERTY, classPathRoot);
		List<Class<? extends FileWalker>> classes = classFinder.findAllMatchingTypes(toMatch);
		assertEquals("found the subclasses of " + toMatch, 2, classes.size());
		assertTrue(classes.contains(JavaClassFileWalker.class));
		assertTrue(classes.contains(FileWalker.class));

		assertTrue(FileFilter.class.isAssignableFrom(JavaClassFileFilter.class));
	}

}
