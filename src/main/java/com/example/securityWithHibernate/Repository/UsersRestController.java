package com.example.securityWithHibernate.Repository;


import com.example.securityWithHibernate.Comparator.UsersComparator;
import com.example.securityWithHibernate.Model.Users;
import com.example.securityWithHibernate.Paging.*;
import com.example.securityWithHibernate.Repository.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.Comparator;
import java.util.List;
import java.util.Locale;
import java.util.function.Predicate;
import java.util.stream.Collectors;

@Service
public class UsersRestController {

    @Autowired
    UserService userService;

    private final Comparator<Users> EMPTY_COMP = (x,y) -> 0;

    private Comparator<Users> getComparator(PagingRequest pagingRequest){

        if(pagingRequest.getOrder() == null )
            return EMPTY_COMP;
        try {
            Order order = pagingRequest.getOrder().get(0);
            Integer columnIndex = order.getColumn();
            Direction dir = order.getDir();
            Column column = pagingRequest.getColumns().get(columnIndex);
            return UsersComparator.getComparator(column.getName(), dir);
        }catch (Exception e){
            e.fillInStackTrace();
        }
        return EMPTY_COMP;
    }

    private Predicate<Users> UsersFilter(PagingRequest pagingRequest){
        if(pagingRequest.getSearch() == null || !StringUtils.hasText(pagingRequest.getSearch().getValue())){
            return user -> true;
        }

        String value  = pagingRequest.getSearch().getValue();
        return user -> user.getName().toLowerCase(Locale.ROOT).contains(value) ||
                       user.getEmail().toLowerCase(Locale.ROOT).contains(value)  ||
                       user.getFirstName().toLowerCase(Locale.ROOT).contains(value);
    }


    private Page<Users> getPage(List<Users> users, PagingRequest pagingRequest){
        List<Users> filteredList = users.stream().sorted(getComparator(pagingRequest))
                                                 .filter(UsersFilter(pagingRequest))
                                                 .skip(pagingRequest.getStart())
                                                 .limit(pagingRequest.getLength())
                                                 .collect(Collectors.toList());
        int count = filteredList.size();
        Page page = new Page(filteredList);
        page.setRecordsTotal(count);
        page.setRecordsTotal(count);
        page.setDraw(pagingRequest.getDraw());
        return page;

    }

    public Page<Users> getUsers(PagingRequest pagingRequest){
        List<Users> list = userService.findAllUsers();
        return null;
    }

}
