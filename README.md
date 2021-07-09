<h1>MySam - Cab Service</h1>

Java / Spring Boot / Spring Data
MongoDB

<h2>Endpoints</h2>

<h3>Create Trip</h3>
```bash
localhost:8080/api/createTrip
```

Body :
```bash
{
    "customerLastName": "Test",
    "customerFirstName": "Test",
    "customerPhone": "0145875432"
}
```
<br/>

<h3>Accept Trip</h3>
```bash
localhost:8080/api/acceptTrip?tripId=
```

Params :
```bash
key : tripId & Value : XXXXXX
```

Headers :
```bash
key : driverId & Value : XXXXXX
```

<br/>

<h3>Start Trip</h3>
```bash
localhost:8080/api/startTrip/?tripId=
```

Params :
```bash
key : tripId & Value : XXXXXX
```

<br/>

<h3>End Trip</h3>
```bash
localhost:8080/api/endTrip/?tripId=
```

Params :
```bash
key : tripId & Value : XXXXXX
```
