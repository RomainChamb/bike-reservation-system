# TEST PROCEDURE

## API

After starting the application
I connected to http://localhost:8080/swagger-ui.html

I use the /bikes to retrieve the 10 default bikes which are created at the creation of the DB

I use the /admin/bikes to create a new bike and then check that it now appears when I use the /bikes

I copy the id of the newly created bike and delete it using /admin/bikes/{id} and verify than it is no longer present in
the result of /bikes

I copy the id of a bike and use it to book a bike using /bikes/book. I check the result using /bikes. The bikes should 
have the status "BOOKED" and the next availability date should be same date as the end of rental date used during the 
booking process as well as the city

I copy the id of the booked bike and id of an another available bike. I use the /bikes/changeBike endpoint. In the result
of /bikes the previous bike should have a status "AVAILABLE" and the next availability date should be the date of the day and
no longer have a city. The second bike should now have a "BOOKED" status, a city and the next availability date according
to the date used during test.


## UI

I connect to the app on http://localhost:8080/
I should see the 10 default bikes

When I click on the "book" link, I should be redirected to the booking page.
After filling the form and clicking on "Book bike" I am redirected to the home page. I should now see the bike updated with
a "BOOKED" status, and a city name and a next availability date correspond to the one use in the form.

