package com.example.securityWithHibernate.Repository;

import com.example.securityWithHibernate.Model.Roles;
import com.example.securityWithHibernate.Model.Users;
import org.hibernate.Criteria;
import org.hibernate.ScrollMode;
import org.hibernate.ScrollableResults;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@Transactional
public class UserService implements UserRepository {

    @Autowired
    SessionFactory sessionFactory;

    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;

    //@Autowired
    //private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override

    public Optional<Users> findByUserName(String name) {
        String hqlRequest = "from Users U JOIN FETCH U.roles where U.name =:name";
        //return sessionFactory.getCurrentSession().get(Users.class,id);
        Query query = sessionFactory.getCurrentSession().createQuery(hqlRequest).setParameter("name",name);
        //return Optional.ofNullable( (Users) query.getResultList().get(0) );
        List<Users> rs = (List<Users>) query.getResultList();
        if(rs.isEmpty()){
            return Optional.empty();
        }
        return Optional.of( (Users) query.getResultList().get(0) );
        //return null;

    }

    @Override
    public Users findByUserEmail(String email) {
        return null;
    }

    @Override
    public boolean deleteUserById(Long id) {
        return false;
    }

    @Override

    public Optional<Users> findById(Long id) {
        String hqlRequest = "from Users U JOIN FETCH U.roles where U.id =:id";
        //return sessionFactory.getCurrentSession().get(Users.class,id);
        Query query = sessionFactory.getCurrentSession().createQuery(hqlRequest).setParameter("id",id);
        return Optional.ofNullable( (Users) query.getResultList().get(0) );
        //return null;
    }

    @Override

    public List<Users> findAllUsers() {
        String hqlRequest = "from Users U JOIN FETCH U.roles";
        Query query = sessionFactory.getCurrentSession().createQuery(hqlRequest);
        //return (Set<Users>) query.getResultStream().collect(Collectors.toSet());
        List<Users> list  =   query.getResultList();
        System.out.println(list.get(0).getRoles());
        return list;


        /*String hqlRequest = "from Users U JOIN FETCH U.roles order by U.name";
        ScrollableResults results = sessionFactory.getCurrentSession().createQuery(hqlRequest).scroll(ScrollMode.FORWARD_ONLY);*/

        /*CriteriaBuilder builder =sessionFactory.getCriteriaBuilder();
        CriteriaQuery<Users> usersCriteriaQuery = builder.createQuery(Users.class);
        Root<Users> root = usersCriteriaQuery.from(Users.class);
        usersCriteriaQuery.select(root);
        Query query = sessionFactory.getCurrentSession().createQuery(usersCriteriaQuery);
        return (Set<Users>) query.getResultStream().collect(Collectors.toSet());*/





    }

    @Override

    public boolean saveUser(Users user) {
        Optional<Users> newUser = this.findByUserName(user.getName());
        if(!newUser.isPresent()){
            /*newUser.map(
                    saveUser ->{
                        saveUser.setRoles(Collections.singleton(new Roles(1L, "USER")));
                        //saveUser.setUserPassword(bCryptPasswordEncoder.encode(saveUser.getUserPassword()));
                        sessionFactory.getCurrentSession().save(saveUser);
                        return true;
                    });*/
            user.setRoles(Collections.singleton(new Roles(1L, "USER")));
            user.setUserPassword(bCryptPasswordEncoder.encode(user.getUserPassword()));
            sessionFactory.getCurrentSession().save(user);
        }
        return false;

    }

    @Override

    public void deleteByUserName(String name) {
        Optional<Users> deleteUser = this.findByUserName(name);
        if(deleteUser.isPresent()){
            sessionFactory.getCurrentSession().remove(deleteUser.get());
        }
    }
}
