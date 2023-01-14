package jpashop;

import com.sun.org.apache.xpath.internal.operations.Or;
import jpashop.domain.ShopMember;
import jpashop.domain.ShopOrder;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class ShopJpaMain {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");

        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction(); // 트랜잭션 생성
        tx.begin(); // 트랜잭션 시작

        try {
            ShopOrder order = em.find(ShopOrder.class, 1L);
            ShopMember member = order.getMember();


            tx.commit();
        }catch (Exception e){
            tx.rollback();
        } finally {
            em.close();
        }
        emf.close();

    }
}