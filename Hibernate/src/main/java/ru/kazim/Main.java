package ru.kazim;

import ru.kazim.DAO.HibernateDAO;
import ru.kazim.model.Message;
import ru.kazim.model.User222;

public class Main {
    public static void main(String[] args) {
        HibernateDAO<Message> hibernateDAO = new HibernateDAO<>(Message.class);
        Message message = new Message();
        message.setId(58);
        message.setText("1232224");
        hibernateDAO.update(message);
        System.out.println(hibernateDAO.findAll().toString());
    }
}