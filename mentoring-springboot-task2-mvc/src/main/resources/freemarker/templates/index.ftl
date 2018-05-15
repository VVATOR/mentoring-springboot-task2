<!-- FreeMarker Macros -->

<#import "/spring.ftl" as spring/>


<!DOCTYPE html>
<head>

<link rel="stylesheet" href="<@spring.theme 'stylesheet'/>" type="text/css" />
</head>
<body>
<a href="?lang=en"><@spring.message 'label.lang.en' /></a>
<a href="?lang=de"><@spring.message 'label.lang.de' /></a>
</br>
<@spring.message 'label.change_theme' />
<a href="?theme=bright"><@spring.message 'label.theme_one' /> |
<a href="?theme=dark"><@spring.message 'label.theme_two' /></a>

  <h1><@spring.message 'label.welcome' /></h1>
  <a href="<@spring.url '/users'/>"><@spring.message 'label.users_list' /></a>
  <br>
    <a href="<@spring.url '/friendships'/>"><@spring.message 'label.friendships_list' /></a>
    <br/>
    <a href="<@spring.url '/users-generate'/>"><@spring.message 'label.user.generation' /></a>



    <br/><br/>

  <h4>H2 webconsole:</h4>
  <a href="<@spring.url '/h2-web-console'/>">h2-webconsole</a>
  <br/>

  <h4>Heapdump:</h4>
  <a href="<@spring.url '/actuator/heapdump'/>">heapdump</a>
  <br/>

  <h4>Loggers:</h4>
  <a href="<@spring.url '/actuator/loggers'/>">loggers</a>
  <br/>

  <h4>Metrics endpoints:</h4>
  <a href="<@spring.url '/actuator/metrics'/>">metrics</a>
  <br/>
  <a href="<@spring.url '/actuator/health'/>">health</a>
  <br/>
  <a href="<@spring.url '/actuator/info'/>">info</a>



</body>
</html>
