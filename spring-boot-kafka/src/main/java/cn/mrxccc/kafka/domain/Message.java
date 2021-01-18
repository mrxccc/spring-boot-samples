package cn.mrxccc.kafka.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;
import java.util.List;

/**
 * @author mrxccc
 * @create 2021/1/18
 */
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Message implements Serializable {
    private static final long serialVersionUID = 6678420965611108427L;

    private String from;

    private String message;

    private List<String> testList;
}
