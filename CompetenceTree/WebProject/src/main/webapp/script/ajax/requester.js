     var xmlHttp;
     var response = "";
     var handler;
     function createXmlHttpRequest()
     {
            if(window.ActiveXObject)
            {
             xmlHttp=new ActiveXObject("Microsoft.XMLHTTP");
           }
         else if(window.XMLHttpRequest)
         {
             xmlHttp=new XMLHttpRequest();
          }
     }
     function handleStateChange()
     {
         if(xmlHttp.readyState==4)
         {
             if(xmlHttp.status==200)
                 {
                   // handler( xmlHttp.responseText);
            	 response = xmlHttp.responseText;
                 }
             else
             {
                alert("Error loading page"+ xmlHttp.status +
     ":"+xmlHttp.statusText);
             }
         }
     }
     function startRequest(reqData,url)
     {
       createXmlHttpRequest();  
       xmlHttp.open("POST",url,false);
       xmlHttp.setRequestHeader("content-type","application/x-www-form-urlencoded");
       xmlHttp.onreadystatechange=handleStateChange;
       
       xmlHttp.send(reqData);
       return response;
     }