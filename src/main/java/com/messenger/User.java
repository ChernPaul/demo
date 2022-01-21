package com.messenger;

import java.util.UUID;

/* TODO: Это сущность. Надо ее в отдельный пакет к сообщениям и чатам */
/* TODO: (доп литература) Можно не создавать явно геттеры, сеттеры, toString, equals, конструкторы (с параметрами/без)
*   можно использовать библиотеку lombok (а конкретно аннотации @Getter @Setter @AllArgsConstructor, @NoArgsConstructor,
*   @ToString, @Builder (!!! очень полезная штука) */
public class User {

    /* TODO: Класс называется User. Значит поля уже по сути "юзеровские". Используй все поля без префикса user */
    private UUID userUUID;

    /* TODO: Просто name */
    private String userName;

    /* TODO: Просто info */
    private String userInfo;

    /* TODO: (не обязательно, но для profit). Логин и пароль (credentials) обычно располагаются в другом классе
        (может быть, во внутреннем)  */
    private String userLogin; /* TODO: Просто login */
    private String userPassword; /* TODO: Просто password */

    public User( UUID userUUID, String userName, String userInfo, String userLogin, String userPassword){
        this.userUUID = userUUID;
        this.userName = userName;
        this.userInfo = userInfo;
        this.userLogin = userLogin;
        this.userPassword = userPassword;

    }

    public UUID getUserUUID() {
        return userUUID;
    }

    public String getUserInfo() {
        return userInfo;
    }

    public String getUserLogin() {
        return userLogin;
    }

    public String getUserName() {
        return userName;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserUUID(UUID userUUID) {
        this.userUUID = userUUID;
    }

    public void setUserInfo(String userInfo) {
        this.userInfo = userInfo;
    }

    public void setUserLogin(String userLogin) {
        this.userLogin = userLogin;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userUUID +
                ", userName='" + userName + '\'' +
                ", userInfo='" + userInfo + '\'' +
                ", userLogin='" + userLogin + '\'' +
                ", userPassword='" + userPassword + '\'' +
                '}';
    }
}
