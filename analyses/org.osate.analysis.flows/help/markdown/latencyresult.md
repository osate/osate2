# Latency Analysis Result Format

[TOC levels=2-4 bullet hierarchy]

Latency analysis records its results in the AnalysisResult format as provided by the org.osate.results plug-in.
A run of the plug-in produces one instance of AnalysisResult stored as a file with the extension result in the reports/latency folder.

## AnalysisResult

The AnalysisResult object contains the following information:

 - **name**: "latencyreport"
 - **sourceReference**: reference to the root of the instance model (SystemInstance) 
 - **analysis**: "org.osate.analysis.flows"
 - **info**: 4 parameters to latency analysis as single string. Each parameter is a 2 character label separated by "-", e.g., "SS-DL-WC-EQ". The labels are explained in the preference documentation (SS/AS, DL)

The AnalysisResult object contains a collection of Result objects, one for each end to end flow and system operation mode combination.

Each end-to-end flow latency Result object contains a collection of subResults that represent latency contributions. 

## End To End Flow Result

The Result object representing the latency results for one end to end flow contains the following information:

- **SourceReference**: reference to the end to end flow instance object in the instance model 
- **Values**: list of values representing the results
- **Diagnostics**: list of observations about the values represented as Diagnostic 

The values of the result are stored in the following order:

1. System operation mode name as String
2. Minimum actual latency total as real/double in milliseconds (ms)
3. Maximum actual latency total as real/double in milliseconds (ms)
4. Minimum latency spec total as real/double in milliseconds (ms)
5. Maximum latency spec total as real/double in milliseconds (ms)
6. Minimum expected end-to-end flow latency as real/double in milliseconds (ms)
7. Maximum expected end-to-end flow latency as real/double in milliseconds (ms)

Actual latency total is the sum of latency contributions by the actual design.

Latency spec total is the sum of latency values associated with flow specifications.

Expected end-to-end flow latency is the latency value specified by the Latency property associated with the end to end flow being analyzed.

ResultUtil provides methods to retrieve the values by index starting with index zero.

## Latency Contribution Result

The Result object representing a latency contribution contains the following information:

- **SourceReference**: reference to the instance model that contributes to the latency. This may be a component or a connection instance.
- **Values**: list of values representing details of the contribution
- **Diagnostics**: list of observations about the contribution 

The values of the contribution are stored in the following order:

1. Minimum actual latency value as real/double in milliseconds (ms)
2. Maximum actual latency value as real/double in milliseconds (ms)
3. Minimum latency spec value as real/double in milliseconds (ms)
4. Maximum latency spec value as real/double in milliseconds (ms)
5. Immediate deadline as real/double in milliseconds (ms)
6. Partition offset as real/double in milliseconds (ms)
7. Partition duration as real/double in milliseconds (ms)
8. Sampling period as real/double in milliseconds (ms)
9. Method to determine worst-case actual latency (String)
10. Method to determine best-case actual latency (String)
11. Indicator as to whether the contributor is synchronous or asynchronous (String)

In the case of connections a contributor can have sub-contributors (protocols, buses that the connection is bound to). They are represented by subResult objects for each contributor Result object.
 