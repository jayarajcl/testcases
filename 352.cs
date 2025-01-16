using System;using System.Web;public class StackTraceHandler : IHttpHandler{    public void ProcessRequest(HttpContext ctx)    {   
     try        {     
       doSomeWork();    
    }        catch (Exception ex)       

 {    
                   ctx.Response.Write(ex.ToString());        
    return;        }   
 }}
