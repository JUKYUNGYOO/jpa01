package com.example.demo;

import org.hibernate.Session;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


@Component
@Transactional
public class JpaRunner implements ApplicationRunner {


    @PersistenceContext
    EntityManager entityManager; //jpa의 기본인 빈을 주입받음.


    @Override
    public void run(ApplicationArguments args) throws Exception{
        Account account = new Account();
        account.setUsername("ann");
        account.setPassword("hibernate");


//        하이버네이트의 가장 핵심적인 API는 Session 이다.

        Session session = entityManager.unwrap(Session.class);
        session.save(account);

//        session으로 저장할 수 있다.

        entityManager.persist(account);

    }

}
