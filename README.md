#### Run Tests

To execute the tests, use the following Maven command:

`mvn test -Dbrowser=<browser> -Dcucumber.filter.tags="<tag>`

### Options

- **Tags:**
  - `@Checkout`
  - `@SearchProducts`

- **Browsers:**
  - `chrome`
  - `firefox`
  - `edge`

**Example**:
`mvn test -Dbrowser=chrome -Dcucumber.filter.tags="@Checkout"`

	