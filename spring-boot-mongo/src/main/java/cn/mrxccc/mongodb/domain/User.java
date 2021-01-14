package cn.mrxccc.mongodb.domain;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * @author mrxccc
 * @create 2021/1/14
 */
@Data
@Document(collection = "user")
public class User {
    @Id
    private String id;

    private String name;

    private Integer age;

    private String description;
}
