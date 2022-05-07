package com.example.securityWithHibernate.Comparator;

import com.example.securityWithHibernate.Model.Users;
import com.example.securityWithHibernate.Paging.Direction;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public final class UsersComparator {

    static private class Key{
        String name;
        Direction dir;

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Key key = (Key) o;
            return Objects.equals(name, key.name) && dir == key.dir;
        }

        @Override
        public int hashCode() {
            return Objects.hash(name, dir);
        }

        Key(String name, Direction dir) {
            this.name = name;
            this.dir = dir;
        }

        String getName() {
            return name;
        }

        Direction getDir() {
            return dir;
        }
    }

    static Map<Key, Comparator<Users>> map = new HashMap<>();

    static {
        map.put(new Key("id",Direction.desc),Comparator.comparing(Users::getId));
        map.put(new Key("id",Direction.desc),Comparator.comparing(Users::getId).reversed());
        map.put(new Key("name",Direction.desc),Comparator.comparing(Users::getName));
        map.put(new Key("name",Direction.desc),Comparator.comparing(Users::getName).reversed());
        map.put(new Key("firstName",Direction.desc),Comparator.comparing(Users::getFirstName));
        map.put(new Key("firstName",Direction.desc),Comparator.comparing(Users::getFirstName).reversed());
        map.put(new Key("lastName",Direction.desc),Comparator.comparing(Users::getLastName));
        map.put(new Key("lastName",Direction.desc),Comparator.comparing(Users::getLastName).reversed());
        map.put(new Key("email",Direction.desc),Comparator.comparing(Users::getEmail));
        map.put(new Key("email",Direction.desc),Comparator.comparing(Users::getEmail).reversed());
    }

    public static Comparator<Users> getComparator(String name,Direction dir){
        return map.get(new Key(name,dir));
    }
}
