<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="utf-8">
    <script src="http://code.jquery.com/jquery-3.4.1.js"></script>
    <title>CrackedCalc</title>
  </head>
  <body>
    <h2>Cracked Calculator</h2>
    <form id="form" action="/crackedcalc/" accept-charset=utf-8>
      <label for="value">Value 1 </label>
      <input id="value" type="text" name="value" onfocus="clearsol()" 
      		pattern="^[-]?[0-9]*[.]?[0-9]*?$" required/>
      <br/>
      <br/>
      <label for="secondValue">Value 2 </label>
      <input id="secondvalue" type="text" name="value" onfocus="clearsol()" 
      		pattern="^[-]?[0-9]*[.]?[0-9]*?$" required/>
      <br/>
      <br/>
      <label for="solution">Solution</label>
      <input id="solution" type="text" name="solution" readonly/> 
      <br/>
      <br/>
      <input type="button" value="Add" onclick="solve(event)">
      <input type="button" value="Substract" onclick="solve(event)">
      <input type="button" value="Multiply" onclick="solve(event)">
      <input type="button" value="Divide" onclick="solve(event)">
    </form>
    <script  type="text/javascript">
	    function solve(event) {
	    	$.ajax({    
	            url: $("#form").attr('action'),
	            data: JSON.stringify({
	        	  			value: document.getElementById('value').value,
	        	  			oneMoreValue: document.getElementById('secondvalue').value,
	        	  			operation: event.currentTarget.value
	            	  	}),
	            type: 'POST',
	            contentType: "application/json; charset=utf-8",
	            dataType: 'json',
	            success: function(data){
	                    	document.getElementById('solution').value = data.value;
	            		},
	            error: function(data){
	            	 document.getElementById('solution').value = 'ERROR';
	            }
	        });
	    } 
	    
	    function clearsol(){
    		document.getElementById('solution').value = '';
    	}
    </script>
  </body>
</html>