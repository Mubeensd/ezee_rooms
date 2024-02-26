<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

  <form action="cust" method="post">
    <table >
            <tr>
            <td>
             room id <input type="text" name="rid"  readonly   value="<%=request.getParameter("rid")%>"> <br><br> 
            </td>
            </tr>
        <tr> 
            <td>
                <label for="">Name</label>
    <input type="text" name="name" placeholder="Enter Customer Name"> <br><br> 
            </td>
        </tr>
<tr>
    <td>
    <label for="">Phone Number</label>
    <input type="text" name="number" placeholder="Enter phone number"><br><br>
    </td>
</tr>
   
   <tr>
            <td>
             Amount <input type="text" name="amt"  readonly   value="<%=request.getParameter("amt")%>"> <br><br> 
            </td>
            </tr>
<tr>
    <td>
    <label for="">Mode of payment</label>
   <select name="mode">
   <option >Cash</option>
   <option>UPI</option>
   <option>Card</option>
   </select><br><br>
    </td>
</tr>
    <tr>
        <td>
            <div class="buton">
                <input type="submit" value="Book">
                <input type="reset" value="Cancle">
            </div>
    
        
        </td>
    </tr>

    

</table>

</form>
</body>
</html>