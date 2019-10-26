<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    
  
        <h1>Add New Student</h1>  
       
       <form:form method="post" action="save">    
			 ${results}       
        <table >    
         <tr>    
          <td>Name : </td>   
          <td><form:input path="name"   required="required"/></td>  
         </tr>    
         <tr>    
          <td>group :</td>    
          <td><form:input path="group" required="required"/></td>  
         </tr>   
         <tr>    
          <td>grade :</td>    
          <td><form:input path="grade" required="required"/></td>  
         </tr>   
         <tr>    
          <td> </td>    
          <td><input type="submit" value="Save" /></td>    
         </tr>    
        </table>    
       </form:form>    