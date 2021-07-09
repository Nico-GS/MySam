<h1>MySam - Cab Service</h1>

Java / Spring Boot / Spring Data
MongoDB

<h2>Endpoints</h2>

<h3>Create Trip</h3>

```bash

localhost:8080/api/createTrip

```

Body :
<code>
{
    "customerLastName": "Test",
    "customerFirstName": "Test",
    "customerPhone": "0145875432"
}
</code>
<br/>

<h3>Accept Trip</h3>

```bash
localhost:8080/api/acceptTrip?tripId=
```

Params :
<code>
key : tripId & Value : XXXXXX
</code>

Headers :
<code>
key : driverId & Value : XXXXXX
</code>

<br/>

<h3>Start Trip</h3>

```bash
localhost:8080/api/startTrip?tripId=
```

Params :
<code>
key : tripId & Value : XXXXXX
</code>

<br/>

<h3>End Trip</h3>

```bash
localhost:8080/api/endTrip?tripId=
```

Params :
<code>
key : tripId & Value : XXXXXX
</code>
