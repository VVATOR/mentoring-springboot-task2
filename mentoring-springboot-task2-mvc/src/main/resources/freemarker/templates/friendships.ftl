<!-- FreeMarker Macros -->

<#import "/spring.ftl" as spring/>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
        <title><@spring.message 'label.users' /></title>
    </head>
    <body>

        <h1><@spring.message 'label.friendships' /></h1>
        <#if friendships??>
            <#assign i = friendships?size>
            <@spring.message 'label.count' /> friendships: ${i}
            <table>
                <thead>
                    <tr>
                        <th><@spring.message 'label.id' /></th>
                        <th><@spring.message 'label.friend_id' /></th>
                        <th><@spring.message 'label.time' /></th>
                    </tr>
                </thead>
                <tbody>
                    <#list friendships as friendship>
                        <tr>
                            <td>${friendship.userId1}</a></td>
                            <td>${friendship.userId2}</a></td>
                            <td>${friendship.timestamp}</td>
                        </tr>
                    </#list>
                </tbody>
            </table>

    </body>
</html>