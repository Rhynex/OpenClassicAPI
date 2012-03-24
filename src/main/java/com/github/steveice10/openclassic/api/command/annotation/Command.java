package com.github.steveice10.openclassic.api.command.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import com.github.steveice10.openclassic.api.command.Sender;


@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Command {

	public String[] aliases();

	public String usage() default "";

	public String permission();

	public int min() default 0;

	public int max() default 64;
	
	public Class<? extends Sender>[] senders() default {};
	
}