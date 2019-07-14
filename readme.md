![Codebuild Badge](https://codebuild.ap-southeast-2.amazonaws.com/badges?uuid=eyJlbmNyeXB0ZWREYXRhIjoibGlhRkxsSEd6NTFDeG5pMUU3a0Z6OVBNQXYvcFhkZ2JJTzQvR25xMTV1QTdhbWt2MHptbE1kdFdqOEF2R2hJOGV6b3pEUVJ3Zmw1YlEvdnNGYmFhTGg0PSIsIml2UGFyYW1ldGVyU3BlYyI6InRMMWEvd0k3M25hRzRmdEoiLCJtYXRlcmlhbFNldFNlcmlhbCI6MX0%3D&branch=master)

- ~~Create a Spring Boot App~~
- ~~Deploy to ELB.~~
- ~~Write a test and every time you push to repo trigger a code build.~~
- ~~Once build is successful do a code deploy and deploy to ELB~~

##### Deploy to ELB.

- 'eb init'
- `eb create --single --database`
- funuser/funuser123. DB name is aa1okyj24v2bn05.


##### To Test

- Create a book

```
curl http://www.AppForFun-dev.ap-southeast-2.elasticbeanstalk.com/api/books -d '{"title":"My First Book","author":"Arun Menon"}' -H 'Content-Type: application/json'
```

- Get List of books

```
curl http://www.AppForFun-dev.ap-southeast-2.elasticbeanstalk.com/api/books
```