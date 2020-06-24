$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("classpath:featureFile/orderUsingAreaCode.feature");
formatter.feature({
  "name": "Use the website to find restaurants",
  "description": "                 So that I can order food\n   \t\t          As a hungry customer\n                  I want to be able to find restaurants in my area",
  "keyword": "Feature"
});
formatter.scenario({
  "name": "Search for restaurants in an area",
  "description": "",
  "keyword": "Scenario"
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "I want food in \"AR51 1AA\"",
  "keyword": "Given "
});
formatter.match({
  "location": "stepDefination.OrderUsingAreaCode.i_want_food_in(java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I search for restaurants",
  "keyword": "When "
});
formatter.match({
  "location": "stepDefination.OrderUsingAreaCode.i_search_for_restaurants()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I should see some restaurants in \"AR51 1AA\"",
  "keyword": "Then "
});
formatter.match({
  "location": "stepDefination.OrderUsingAreaCode.i_should_see_some_restaurants_in(java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
});