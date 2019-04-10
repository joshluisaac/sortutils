## The problem statement:

Create an application that can sort a list of distances (in ascending order based on length).

> I framed this as a sort problem which will require a sorting algorithm of some kind.

## System requirements/scope/considerations and questions.

### Input data/payload requirements.

REQ 01. the application should receive an unsorted list passed into the system.

> Q0. What is the size of the request payload? Knowing this would dictate how the payload is served in the event that it is served up via HTTP request. Consider creating a custom header or appending this to the request body due to query string limitation on most browsers and maxQueryString settings on most web/proxy servers.

> Q1. How should the list be fed into the system? Via terminal/command line, HTTP/RESTFul request payload etc..

> Q2. How should the payload/list be formatted? As a raw string, ASCII/fixed length, CSV, pipe delimited, JSON, XML etc..

> Q3. Should there be an encoding/encryption process in place if request is via HTTP?

### Duplication and data redundancy.

REQ 02. Duplicate distances should not be included in the sorted output. Although, if a duplicate distance is detected, an appropriate message should be output to the log.

> Implement a unique procedure (method/function) of somekind which will take the unsorted list as input data and then strip off duplicates from it spitting out a list of unique elements. This would reduce the number of passes/iterations the sorting algorithm would have to do thereby leading to significant performance improvements.

> **What am i thinking right now**: Off the of my head, i am visualizing something like this `public <T> List<T> doUnique(List<T> unsortedList){ return uniqueList }`. This will go into a util or helper package as it seems to me as a utility or helper which i need to get my core functionality done.

### Exception handling.

REQ 03: Appropriate error handling should be considered for obvious failure cases.

> The input data is error-prone by the mere fact that it is keyed-in my the end user. Consider vaidating the input param first before doing any further processing. Log to console and throw an exception if validation fails.

> If the input data is JSON formatted use a JSON parser (gson is a good library) to validate if what is passed in, is actually JSON formatted. Consider throwing an `IllegalArgumentException` or your own custom exception with the actual cause wrapped in.

## Design phase

0. Input validation: Parse & validate if the passed input is actually JSON formatted. Proceed it is or exit it isn't. Consider implementing a method like this `java public static boolean isValidJson(final String maybeJson){}` in some `InputValidationParser` class

1. The request payload is a list of distances. Distance could be measured in various metric units `(KM, M, CM, MM, Feet, Inch, Yard, Mile, Nautical Mile...)` the question is silent as to how many units must be supported. I followed Occam's razor problem-solving principle that recommends going with simplier solutions than very complex ones. I decided to be very specific on which units this solution will support as opposed to developing a generic/generalistic one. Yes, distances would be measured in feet, inch, yard..but this is rare. I chose `KM,M,CM,MM`

**What am i thinking right now**: Off the top of my head, I'm looking at an input like this

```json
{
  "distances": [
    {
      "key": "cm",
      "value": 1.367
    },
    {
      "key": "km",
      "value": -1.37
    },
    {
      "key": "mm",
      "value": 1
    },
    {
      "key": "mm",
      "value": 1
    },
    {
      "key": "km",
      "value": 1.976
    },
    {
      "key": "km",
      "value": 1.976
    }
  ]
}
```

> Create an enum class which will be a reference for looking up the various supported units. `DistanceUnitType.java`

> Create a Distance map class which will take a key/value pairs. Each distance value is associated with a unit. `DistanceMap.java`

> Create a Distance class which is a representation of the entire distance model. That is a list of distance maps, `List<DistanceMap>`. Call this `Distance.java`

2. The raw JSON payload is a serialized form. That is, it currently exists in a file system on disk or a memory buffer. I will need to do some deserialization to plain Java objects.

> Deserialize from `JSON` formatted string to `Distance` object. I'm looking at something along these lines `public Distance deserialize(String jsonText){}`

3. Map distance to list of same types.

4. Remove duplicates `public <T> List<T> unique(List<T> list){}`

5. map distance to an array of doubles to facilitate comparison and sorting. Sorting performs best with array data structure.

6. Execute sort.

7. Build sort response `SortResponse`
