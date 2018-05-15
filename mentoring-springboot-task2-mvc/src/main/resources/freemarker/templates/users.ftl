<!-- FreeMarker Macros -->

<#import "/spring.ftl" as spring/>


<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
        <title><@spring.message 'label.users' /></title>
    </head>
    <body>
    <#if users??>
        <#assign i = users?size>
        <@spring.message 'label.count' /> users: ${i}

        <table>
            <thead>
                <tr>
                    <th><@spring.message 'label.user_name' /></th>
                    <th><@spring.message 'label.user_surname' /></th>
                    <th><@spring.message 'label.user_birth' /></th>
                    <th><@spring.message 'label.edit' /></th>
                    <th><@spring.message 'label.remove' /></th>
                </tr>
            </thead>
            <tbody>
                <#list users as user>
                    <tr>
                        <td><a href="<@spring.url '/users/${user.id}'/>">${user.name}</a></td>
                        <td>${user.surname}</td>
                        <td>${user.birth}</td>
                        <td><a href="<@spring.url '/users/edit_user/${user.id}'/>"><@spring.message 'label.edit' /></a></td>
                        <td><a href="<@spring.url '/users/remove/${user.id}'/>"><@spring.message 'label.remove' /></a></td>
                    </tr>
                </#list>
            </tbody>
        </table>
    <#else>not found users</#if>
        <a href="<@spring.url '/users/edit_user'/>"><@spring.message 'label.user_add' /></a>
    </body>
</html>