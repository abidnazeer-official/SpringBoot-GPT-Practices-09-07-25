package com.examplep2.demop2;

import java.util.concurrent.RecursiveAction;

import com.examplep2.demop2.controller.UserController;

import org.antlr.v4.runtime.tree.Trees;
import org.hibernate.graph.GraphSemantic;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Demop2Application {

    private final UserController userController;

    Demop2Application(UserController userController) {
        this.userController = userController;
    }

	public static void main(String[] args) {
		SpringApplication.run(Demop2Application.class, args);


	}

}
