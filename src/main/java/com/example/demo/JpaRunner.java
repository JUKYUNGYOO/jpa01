package com.example.demo;

import org.hibernate.Session;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;


@Component
@Transactional
public class JpaRunner implements ApplicationRunner {


    @PersistenceContext
    EntityManager entityManager; //jpa의 기본인 빈을 주입받음.


    @Override
    public void run(ApplicationArguments args) throws Exception{

        List<Post> posts = entityManager
                .createNativeQuery("SELECT * FROM Post", Post.class)
                .getResultList();

        posts.forEach(System.out::println);

//        TypedQuery<Post> query = entityManager.createQuery("SELECT p FROM Post As p", Post.class);
//        List<Post> posts = query.getResultList();
//        posts.forEach(System.out::println);


//        entityManager.createNamedQuery("all_post",Post.class);

        //타입 세이프한 방법
//        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
//        CriteriaQuery<Post> query = builder.createQuery(Post.class);
//        Root<Post> root = query.from(Post.class);
//        query.select(root);
//
//        List<Post> posts = entityManager.createQuery(query).getResultList();
//        posts.forEach(System.out::println);



//        Post post  = new Post();
//        post.setTitle("Spring Data Jpa는 언제보나");
//
//        Comment comment = new Comment();
//        comment.setComment("빨리 보고 싶어요");
//        post.addComment(comment);
//
//        Comment comment1 = new Comment();
//        comment1.setComment("곧 보여드릴게요");
//        post.addComment(comment1);
//
//
//          Session session = entityManager.unwrap(Session.class);
//          Post post = session.get(Post.class,4l);
//          System.out.println("==========================");
//          System.out.println(post.getTitle());
//          post의 제목을 뿌리

//        session.delete(post);

//        session.save(post);
//        post 만 테이블에 저장됨.
//        Comment comment = session.get(Comment.class,5l);
//        System.out.println("==============");
//        System.out.println(comment.getComment());
//        System.out.println(comment.getPost().getTitle());

//        post.getComments().forEach(c -> {
//            System.out.println("==================");
//            System.out.println(c.getComment());
//
//        });
//post에 관련된 comment를 전부 읽어옴.

    }

}
