<!-- FreeMarker Macros -->

<#import "/spring.ftl" as spring/>


<!DOCTYPE html>
<html>
    <head>
        <style>
        .error {
        	color: #ff0000;
        }

        .errorblock {
        	color: #000;
        	background-color: #ffEEEE;
        	border: 3px solid #ff0000;
        	padding: 8px;
        	margin: 16px;
        }
        </style>
    </head>
   <body>

   <h1><@spring.message 'label.user.generation' /></h1>
    <div align="center">
        <form action="<@spring.url '/users-generate/'/>" method="get">
            <table border="0">
                <tr>
                    <td><@spring.message 'label.count' /></td>
                    <td><input type="text" name="count" placeholder="1000"/></td>
                </tr>
                <tr>
                    <td colspan="2" align="center">
                      <input type="submit" value="Submit" /></td>
                </tr>
            </table>

        </form>
        </div>
   </body>
</html>