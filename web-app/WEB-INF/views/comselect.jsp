<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="viewport" content="width=device-width, initial-scale=1">
	<title>Document</title>
    <!-- Bootstrap -->
    <link href="/static/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="//cdnjs.cloudflare.com/ajax/libs/normalize/3.0.1/normalize.min.css">
	<link rel="stylesheet" href="/static/css/combo.select.css">

    <script src="https://cdn.jsdelivr.net/npm/html5shiv@3.7.3/dist/html5shiv.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/respond.js@1.4.2/dest/respond.min.js"></script>
    <script src="//cdnjs.cloudflare.com/ajax/libs/jquery/1.11.0/jquery.min.js"></script>
    <script src="/static/js/jquery.combo.select.js"></script>
    <script src="/static/js/bootstrap.min.js"></script>
  <style>
    .demo-form{
      padding: 15px;
      margin: 20px auto;
    }

    @media only screen and (min-width: 960px){
      .demo-form{
        width: 500px;
      }
    }
  </style>
</head>
<body>


<form method="get" class=demo-form>
    <label for='day-select'>Select day</label>
	<select name=dt required id='day-select'>
    <option value="">Select day</option>
<option value='01'>01</option>



<option value='02' disabled>02 - Disabled</option>
<optgroup label="Optgroup">
  <option value='03'>03</option>
  <option value='04'>04</option>
  <option value='05'>05</option>
</optgroup>

<option value='06'>06</option>
<option value='07'>07</option>
<option value='08'>08</option>
<option value='09'>09</option>
<option value='10'>10</option>
<option value='11'>11</option>
<option value='12'>12</option>
<option value='13'>13</option>
<option value='14'>14</option>
<option value='15'>15</option>
<option value='16'>16</option>
<option value='17'>17</option>
<option value='18'>18</option>
<option value='19'>19</option>
<option value='20'>20</option>
<option value='21'>21</option>
<option value='22'>22</option>
<option value='23'>23</option>
<option value='24'>24</option>
<option value='25'>25</option>
<option value='26'>26</option>
<option value='27'>27</option>
<option value='28'>28</option>
<option value='29'>29</option>
<option value='30'>30</option>
<option value='31'>31</option>
</select>

<select>
	<option value=''>Select Month</option>
    <option value='01'>January</option>
    <option value='02'>February</option>
    <option value='03' selected>March</option>
    <option value='04'>April</option>
    <option value='05'>May</option>
    <option value='06'>June</option>
    <option value='07'>July</option>
    <option value='08'>August</option>
    <option value='09'>September</option>
    <option value='10'>October</option>
    <option value='11'>November</option>
    <option value='12'>December</option>
</select>

<select id="year" name="year" style="width: 150px">
  <option value="">Year</option>
  <script>
  var myDate = new Date();
  var year = myDate.getFullYear();
  for(var i = 1900; i < year+1; i++){
    document.write('<option value="'+i+'">'+i+'</option>');
  }
  </script>
</select>

<select>
              <option value="">Select</option>
              <option>on illegal practices under the Employment Act</option>
              <option>on illegal employment or deployment of foreign workers</option>
              <option>on false declaration of foreign workers' salary or qualification</option>
              <option>on use of locals as 'Phantom Workers'</option>
              <option>on unauthorised collection of money from foreign workers as condition of employment ('Kickbacks')</option>
              <option>on any other breach of the Employment of Foreign Manpower Act or Work Pass Conditions (Example : Failure option to repatriate, medical obligation issues, etc.)</option>
              <option>on unacceptable accomodation conditions for foreign workers </option>
              <option>on the well-being issues of Foreign Domestic Worker (FDW)</option>
              <option>against Employment Agency or unlicensed Employment Agency</option>
              <option>about a workplace safety and health issue (infringement)</option>
              <option>non-compliance with Employment Act and CPF Act</option>
              <option>on a discriminatory job advertisement</option>
              <option>on nationality based discrimination at workplacesoption </option>
            </select>

<h3>Option groups</h3>

<select>
  <option>Option 1</option>
  <optgroup label="Group 1">
    <option>Option</option>
    <option>Option</option>
  </optgroup>
  <optgroup label="Group 2">
    <option>Option</option>
    <option>Option</option>
  </optgroup>
</select>

<h3>on Change event : <a href="#" class="js-select-add">Add new option</a></h3>

<select class="js-select js-select-3">
  <option value="">Select an option</option>
  <option>Option 1</option>
  <option>Option 2</option>
  <option>Option 3</option>
  <option>Option 4</option>
  <option>Option 5</option>
  <option>Option 6</option>
</select>

<div class="selected">
  <p>Selected Index: <span class="idx"></span></p>
  <p>Selected Value: <span class="val"></span></p>
</div>

<pre>
  <code>
$('select').change(function(event){
    console.log(event.target.selectedIndex)
    console.log(event.target.value)
})
  </code>
</pre>


<h3>Trigger Handlers</h3>

<ul>
  <li>ComboSelect Open : <pre>comboselect:opened</pre>: <a href="#" class="js-select-open">Open select</a></li>
  <li>ComboSelect Open : <pre>comboselect:close</pre>: <a href="#" class="js-select-close">Close select</a></li>
  <li>ComboSelect Update: <pre>comboselect:update</pre>: <a href="#" class="js-select-add">Add new option</a></li>
  <li>All other events will work as normal: Hover, focus, Blur</li>
</ul>

</form>

<script>
    $(function(){

        $('select')
        .comboSelect()

  /**
   * on Change
   */

  $('.js-select').change(function(e, v){
      $('.idx').text(e.target.selectedIndex)
      $('.val').text(e.target.value)
  })

  /**
   * Open select
   */

  $('.js-select-open').click(function(e){
    $('.js-select').focus()
    e.preventDefault();
  })

  /**
   * Open select
   */

  $('.js-select-close').click(function(e){
    $('.js-select').trigger('comboselect:close')
    e.preventDefault();
  })

  /**
   * Add new options
   */

  var $select = $('.js-select-3');

  $('.js-select-add').click(function(){
    $select.prepend($('<option>', {
      text: 'A new option: ' + Math.floor(Math.random() * 10) + 1
    })).trigger('comboselect:update')

    return false;
  })

    })
</script>
</body>
</html>