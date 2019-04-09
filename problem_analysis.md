## The problem statement:

Create an application that can sort a list of distances (in ascending order based on length).

> Scoped this as a sort problem which will require a sorting algorithm of some kind.

## System requirements

### Input data/payload requirements.

REQ 01. the application should receive an unsorted list passed into the system.

> Q0. What is the size of the request payload? Knowing this would dictate how the payload is served in the event that it is served up via HTTP request. Consider creating a custom header or appending this to the request body due to query string limitation on most browsers and maxQueryString settings on most web/proxy servers.

> Q1. How should the list be fed into the system? Via terminal/command line, HTTP/RESTFul request payload etc..

> Q2. How should the payload/list be formatted? As a raw string, ASCII/fixed length, CSV, pipe delimited, JSON, XML etc..

> Q3. Should there be an encoding/encryption process in place if request is via HTTP?

### Duplication and data redundancy.

REQ 01. Duplicate distances should not be included in the sorted output. Although, if a duplicate distance is detected, an appropriate message should be output to the log.

> Implement a unique procedure (method/function) of somekind which will take the unsorted data as input data and then strip out duplicates from it. This would reduce the number of passes/iterations the sorting algorithm would have to do thereby leading to significant performance improvements.

> Off the of my head i am visualizing something like this `public <T> List<T> doUnique(List<T> unsortedList){ return uniqueList }`
