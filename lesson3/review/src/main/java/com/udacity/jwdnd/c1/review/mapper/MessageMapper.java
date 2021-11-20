package com.udacity.jwdnd.c1.review.mapper;

import com.udacity.jwdnd.c1.review.model.ChatMessage;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
public interface MessageMapper {

    @Select("select * from MESSAGES where username = #{username}")
    ChatMessage getMessage(String username);

    // note: retrieve all the messages in the database
    @Select("select * from MESSAGES")
    List<ChatMessage> getAllMessages();

    @Insert("insert into MESSAGES (username, messagetext) values(#{username}, #{messageText})")
    @Options(useGeneratedKeys = true, keyProperty = "messageId")
    int insert(ChatMessage chatMessage);
}


//@com.udacity.jwdnd.c1.review.Mapper
//public interface MessageMapper {
//
//    @Select("SELECT * FROM MESSAGES")
//    List<ChatMessage> getAllMessages();
//
//    @Insert("INSERT INTO MESSAGES (username, messagetext) VALUES(#{username}, #{messageText})")
//    @Options(useGeneratedKeys = true, keyProperty = "messageId")
//    int addMessage(ChatMessage chatMessage);
//
//}
