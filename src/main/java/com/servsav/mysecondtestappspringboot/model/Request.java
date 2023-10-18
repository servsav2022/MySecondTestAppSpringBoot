package com.servsav.mysecondtestappspringboot.model;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Request {
    /**
     * Уникальный идентификатор сообщение
     */
    @Size(max = 32)
    @NotBlank (message = "Не заполнено поле uid")
    private String uid;
    /**
     * Уникальный идентификатор операции
     */
    @Size(max = 32)
    @NotBlank (message = "Не заполнено поле operationUid")
    private String operationUid;
    /**
     *Имя системы отправителя
     */
    private Systems systemName;
    /**
     * Время создания сообщения
     */
    @NotBlank (message = "Не заполнено поле systemTime")
    private String systemTime;
    /**
     * Наименование ресурса
     */
    private String source;
    /**
     * Должность
     */
    private Positions position;
    /**
     * оклад
     */
    private Double salary;
    /**
     * премия
     */
    private Double bonus;
    /**
     * кол-во рабочих дней в году
     */
    private Integer workDays;
    /**
     * Уникальный идентификатор коммуникации
     */
    @Min(1)
    @Max(100000)
    private int communicationId;
    /**
     * Уникальный идентификатор шаблона
     */
    private int templateId;
    /**
     * Код продукта
     */
    private int productCode;
    /**
     * Смс код
     */
    private int smsCode;
    @Override
    public  String toString() {
        return "{" +
                "uid='" + uid + '\'' +
                ", operationUid='" + operationUid + '\'' +
                ", systemName='" + systemName + '\'' +
                ", systemTime='" + systemTime + '\'' +
                ", source='" + source + '\'' +
                ", position='" + position + '\'' +
                ", salary=" + salary +
                ", bonus=" + bonus +
                ", workDays=" + workDays +
                ", communicationId=" + communicationId +
                ", templateId=" + templateId +
                ", productCode=" + productCode +
                ", smsCode=" + smsCode +
                "}";
    }
}
