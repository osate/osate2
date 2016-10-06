# Spotlight for the Alisa Framework

## What Is Spotlight?

Spotlight is a plugin that draws the architect’s attention to which leaf components in an AADL model should be considered next for further analysis, requirements re-allocation, design, or decomposition.

As an architect develops an AADL model, decomposing components into subcomponents, sometimes the requirements allocated to a subcomponent (as specified in the associated Alisa ReqSpec) make the further development of that component potentially infeasible. Over a period of time, following multiple such decompositions, multiple leaf components may have been created that have high uncertainty associated with them; and the architect might lose track of which leaf components to pursue next for further specification, analysis, and decomposition.

And that is where Spotlight comes in.

When invoked, Spotlight evaluates each leaf component of an architect's AADL model to estimate the degree of uncertainty residing in the further and successful development of that component. Uncertainty is estimated in terms of worst case minus best case development time for that component; and is measured in person months of development effort. When its evaluation is completed, Spotlight returns the list of leaf components sorted in order of decreasing potential for uncertainty reduction (PUR).

### Who Is Spotlight for?

Spotlight is intended for architects who are using both AADL and Alisa:

* AADL for developing an architectural model
* Alisa for specifying and allocating requirements within the AADL model.

### What Is Spotlight Applied to?

Spotlight is applied to an instantiation of an AADL model. For example, an instantiation of a system component within an AADL model will cause Spotlight to evaluate all leaf components that are descendants of that system component for which Alisa ReqSpec specifications have been created.

More precisely, Spotlight analyzes the architecturally-significant requirements (ASRs) allocated to leaf components as these tend to be business-critical and may be challenging to design a solution to meet.

### When/how Is Spotlight Applied?

The architect invokes Spotlight on an instance model by right clicking on the instance, which brings up the Context Menu, and then selecting Spotlight from the Context Menu. 

## Questions—what questions does Spotlight help answer?

At the system level, Spotlight helps the architect assess, given the requirements (Alisa ReqSpec files) and architecture (AADL model), can such a system even be built, or might it take too much development effort due to poor requirements allocation and architectural decisions?

At a more detailed level, Spotlight helps track potential-for-uncertainty-reduction (PUR) status of all leaf components of an AADL model and thus helps answer these lower-level questions:

* Which leaf components most need further specification and analysis, given the uncertainty as to their feasibility? 
* Which leaf components contribute most to overall uncertainty whether a system can be designed and implemented to meet the requirements?
* Based only on the architecturally-significant requirements allocated to a particular leaf component, and assuming all other things are equal (e.g., software size), how much effort might it take to develop that component, worst case vs. best case? 

The above are different ways to ask almost the same question, with the final wording being the most precise. 

The bottom line is that system stakeholders can’t have confidence that a system can be architected to meet the requirements until the feasibility of every component specified for that system has been analyzed and a feasible solution identified.

Spotlight estimates feasibility by considering, from the requirements that are allocated to a leaf component alone, worst-case versus best-case, how much uncertainty is there whether such a component can be built, with uncertainty quantified in terms of range of effort (person months) further design and implementation might require.

## What does the output of Spotlight look like?

Output from Spotlight will look something like this:

![](images/spotlightoutput.png) 

The AADL model that Spotlight was applied to above has many components; the display above was created by Spotlight when it was applied to the c2 component instance. (A longer prioritized list would appear had an instance of the root component been selected.) There are eight leaf component descendants of the c2 component and they are listed above in descending order according to their potential for uncertainty reduction (PUR). Note that leaf component c11 has the highest PUR, while c7 has the least, about one-twelfth as much.

### What does this output of Spotlight mean? 

Spotlight quantifies the uncertainty associated with each leaf component through a quantity called the Potential for Uncertainty Reduction (PUR).

* PUR is a proxy for the reduction of development risk that can be achieved by further architecture and design of a particular leaf component
* The higher the PUR, the higher the priority that should (might) be given to that leaf component for further specification, analysis, and architecting.

If we eyeball the PUR for all these components, we’ll see that the overall uncertainty as to the amount of effort it will take to develop the system is around 30,000 person months, or 2,500 person years. That’s a lot! Not many stakeholders will want to commit (or continue to commit) to developing a particular system architecture for which there is about 1,250 plus-or-minus person years of uncertainty in effort. 

Spotlight outputs the results of a worst-case analysis versus best-case analysis of how much development time each of an architecture’s leaf components could take, based on an analysis of their architecturally-significant requirements (ASRs), and assuming all other things can be treated equal (including software size, which is generally not known at this point). The difference in worst-case versus best-case development times for leaf component c11 is about twelve times that of c7. This suggests that if the architect were to choose c11 as the leaf component to specify and analyze next, about twelve times as much uncertainty in development effort might be reduced. The impact from finding and specifying a solution for component c11 could reduce the overall uncertainty by about 7,000 person months or almost 600 person years. While the overall uncertainty is still high, addressing c11 could reduce that uncertainty substantially.

Remember that the feasibility and practicality of an overall solution for the entire set of requirements depends on the correctness of the architecting done to date (the AADL model) and the feasibility of meeting the requirements associated with leaf components, and if the further architecting or development of any of those leaf components should prove to be infeasible, then the confidence of successful development must be low.

### What else does the display show?

The first column lists all the component instances (by component name). 

The second column identifies each component’s classifier. Knowing the classifier is helpful to recognizing some of the characteristics of that component (in our artificial example, we didn’t use very illuminating names, but we could have). But knowing the classifier is also helpful for tracking down the declaration of that component so the architect can analyze it, refine its requirements, decompose it into sub-components, etc.

The third column identifies the number of architecturally-significant requirements (ASRs) that are associated with each component. You will note that the leaf components are almost sorted in ASR order. Indeed, only the position of the first two leaf components are inverted. As a first order of approximation, the more the ASRs that are mapped to a leaf component, the more development risk associated with it; but note that leaf components having 2 ASRs each vary substantially on PUR, suggesting that the number of ASRs is sometimes too coarse to meaningfully differentiate leaf components according to degree of feasibility. Some cost estimation models for software include a count of the number of requirements allocated to a component as a measure of its complexity or difficulty; and Spotlight somewhat works that way too, while also focusing on other factors.

The fourth (and final) column identifies the potential for uncertainty reduction for each displayed leaf component. PUR is the difference in development time, worst-case versus best-case. An explanation of how it is calculated is given in the Algorithm section below, but here we’ll note what its magnitude signifies. Leaf component c11 has a PUR of about 7000. This number is a crude approximation of how much more effort, in person months, it might take to develop c11 in a worst-case vs. best-case development scenario (again, with all things being equal, such as development team, process, and platform capabilities). Thus c11 could take as much as 600 years of person effort; there’s just too little information that can be gleaned just from the requirements to pin down more precisely how much development effort is associated with c11. In contrast, c7, with a PUR of about 600, has about a 50-person years of effort differential, worst-case vs. best-case. Further attention on c7 might not be as beneficial as attention on c11, where some refinement of c11, some decomposition into more recognized solutions, or some better partitioning of requirements to its subcomponents might reduce the overall PUR much more dramatically. So, c11 seems to pose MUCH more uncertainty than c7.

Where do numbers such as 7021 and 591 come from? To answer this question, we describe the inputs that Spotlight needs; the algorithm Spotlight uses to estimate effort; and the assumptions (and default parameter settings) that allow Spotlight, with a minimum of user input, to estimate PUR.

## What is required to invoke Spotlight? What must the architect’s AADL model contain?

Spotlight requires the architect to keep an AADL model’s leaf components-associated ReqSpec files up-to-date.

ReqSpec files contain zero or more architecturally-significant requirements (ASRs), and in particular, their specifications need to be kept up-to-date so that Spotlight can draw the correct inferences from their specification. 

The term ASR has been defined multiple ways. We adopt this definition: ASRs are requirements appearing in an Alisa ReqSpec file that have been assigned a quality attribute (i.e., contain a clause of the form: Quality.<name of attribute>). There are three quality attributes that Spotlight focuses on: Safety, Security, and Performance.

In order for Spotlight to properly interpret an ASR specification, an ASR must have been:

* Rated Low, Medium, or High (i.e., 1, 2, or 3, respectively) on two scales:
* Precedented-ness: is the development team experienced in working with this type and stringency of requirement?
* Anticipated volatility: how much is the requirement likely to change during development?
* Classified as Safety, Security, and/or Performance: note that a requirement may receive anywhere from zero to three such classifications.

Of course, the architect will need to maintain these ASR ratings and classifications as the Alisa specification and AADL model evolve. For example, this means that the architect will need to:

* Establish new ratings and classifications as new requirements are specified
* Adjust these ratings and classifications as existing requirements are modified
* Keep all ReqSpec files associated with leaf components of an AADL model up-to-date and complete.

## Algorithm Used By Spotlight

The explanation of the algorithm is lengthy, in part because of the many COCOMO II parameters that need to be discussed, so we segment the explanation into many shorter subsections, beginning with an overview.

### Overview of Algorithm

In a nutshell, the Spotlight algorithm proceeds as follows for each leaf component:

1. From the ReqSpec, assess risk-bearing properties of the requirements:

* Are any requirements categorized as Safety, Security, and/or Performance?
* What are the Precedented-ness and Volatility ratings for these ASRs?
* Does the component have multiple ASRs that need to be satisfied? Are they potentially competing (e.g., Security vs. Performance)?

2. Construct COCOMO II models to address worst-case (WC) and best-case (BC) development scenarios

* Step 2.1. Infer ratings for several COCOMO II parameters from the leaf component’s ReqSpec
* Step 2.2. Assign default ratings for remaining COCOMO II parameters assuming a savvy development team
* Step 2.3. Apply the COCOMO II effort estimation formula

3. Compute the Potential-for-Uncertainty-Resolution (PUR), which is the difference in WC and BC effort estimates

Note that the algorithm has three principal steps, but three sub-steps for the second step. The subsections that follow cover the algorithm steps and sub-steps in some detail; but these subsections are interspersed with other subsections that either lay some essential groundwork for understanding these steps and sub-steps; or provide additional detail for particular steps.

### Why COCOMO?

COCOMO is a widely used formula for estimating effort and schedule. COCOMO II has been in use since 2000 and continues to be used today. Unlike many other widely-used cost estimation models, a detailed description and software for COCOMO II are publicly available. 

Spotlight’s implementation of Spotlight does not use a labor-cost parameter and therefore only estimates effort, in units of person months.

When only rough effort estimates are sought—as in the case for Spotlight—the COCOMO II effort estimation model can be used with default settings for unknown parameters and achieve reasonable accuracy; especially if the assumption that Spotlight makes about there being a savvy development team is reasonably accurate.
 
Some COCOMO II parameters relate directly to the requirements allocated to a component and thus the resulting effort estimate is, in significant part, requirements driven, which aligns well with Spotlight’s algorithm, which uses the number, properties (ratings and classifications), and potential interactions of requirements allocated to a leaf component to evaluate development risk.

An official source for COCOMO II is the COCOMO 2.0 Model Definition Manual, which can be easily found online by googling the title. Full explanations for each of the COCOMO II parameters can be found there.

Of the 23 parameters used by the COCOMO II effort formula that Spotlight needs to determine ratings for:

* 5 are given ratings based on information available in a leaf component’s ReqSpec file
* 18 are given default project-wide ratings typical of a savvy development team

### COCOMO II’s Ordinal Scale

All of these 23 parameters appearing in the COCOMO II effort estimation formula, except for REVL (explained further below), are evaluated on a six-level ordinal scale in COCOMO II: Very Low, Low, Nominal, High, Very High, and Extremely High. And for each level of each parameter, COCOMO II assigns a specific real number, which is the value that the parameter takes in the COCOMO II effort estimation formula.

The Spotlight algorithm thus assigns one of these six level ratings (and associated real numbers) to each of the 23 parameters; and a primary purpose of the next few subsections is to explain how Spotlight accomplishes that assignment.

### In what ways are the WC versus BC development scenarios different?

For both WC and BC effort estimation, Spotlight assumes a savvy (very capable) development team, which is the basis for assigning default rating levels for 4 of the 5 scale factors and 14 of 17 effort multipliers of the COCOMO II effort estimation formula for all leaf components, project-wide. (Note that in any actual application of COCOMO II, whichever development scenario is considered, these parameters given default rating levels are not likely to vary very much anyway as the development team, process, platform, project characteristics are already likely to be largely determined.) Thus, the two development scenarios analyzed by Spotlight do not differ on these 4+14 parameters but rather on the 5 parameters given ratings based on information available in a leaf component’s ReqSpec file. Bear this in mind when reading the description of the first two steps below, whose descriptions follow, because these 5 parameters are the source for the difference in WC versus BC development scenarios.

### Step 1. From the ReqSpec, assess risk-bearing properties of the requirements

The following are counted for each leaf component: number of requirements classified as Safety, Security, and Performance.

In addition, the distribution of Volatility and Precedented-ness ratings assigned to ASRs is analyzed.

For example, component c11 is declared as follows. Note that c11 has four associated architecturally-significant requirements (ASRs).

![](images/componentreqspec.png) 

The counts for Safety, Security, and Performance are 2, 1, and 3, respectively. (The last two ASRs each contribute to two of these three counts, which is why the sum (6) is higher than the number of ASRs.)

Likewise, the ratings for Precedented-ness and Volatility (both are rated on a scale of 1-to-3, with 1 representing Low and 3 representing High), for the four ASRs are:

* Precendented-ness: 3, 2, 3, 1
* Volatility: 1, 3, 2, 1

(ASR Impact ratings are ignored as it is assumed all ASRs have high business impact.)

The specific values derived from the above and used in subsequent steps of the algorithm for calculating specific COCOMO II parameters are (all five four-letter parameters are further explained in the section describing Step 2.1):

* For calculating REVL: Max Volatility, Median Volatility (for c11: 3 and 1.5, respectively)
* For calculating PREC: Median Precedented-ness (for c11: 2.5)
* For calculating RELY: count for Safety, count for Security (for c11: 2 and 1, respectively)
* For calculating CPLX: count for Safety, count for Security, and count for Performance (for c11: 2, 1, and 3, respectively; as already noted)
* For calculating TIME: count for Performance (for c11: 3)

### Step 2. Construct COCOMO II models to address worst-case (WC) and best-case (BC) development scenarios

As mentioned in the Algorithm Overview, Step 2 consists of several sub-steps, which are further covered below.

### Step 2.1. Infer ratings for several COCOMO II parameters from a leaf component’s ReqSpec

Ratings are calculated for the following five COCOMO II parameters. The four-letter name by which the parameter is referred to in the COCOMO 2.0 Model Definition Manual is given, and then this is followed by a brief description of the parameter and why it is significant:

* REVL (Requirements Evolution and Volatility) is the percentage of code that needs to be replaced in development due to requirements evolution. Requirements evolution can be due to any of these sources: Mission, interfaces, technology, COTS, and changes to stakeholders.
* PREC (Precedented-ness) addresses the overall newness and uniqueness of what the project is supposed to develop: how similar is the leaf component to other components the organization has developed, both in requirements and solution?
* RELY (Required Software Reliability) addresses the extent to which the software must perform its intended function over a period of time and avoid major loss. While there will be exceptions, due to the assumed safety-critical nature of the domain, many components will require Very High reliability.
* CPLX (Product Complexity) represents complexity due to: Control, Computation, Device-dependence, Data-management, and User Interface Management operations. CPLX has the highest potential impact on effort among the five Product Factors (more about them below). Due to the nature of the domain, product complexity will likely be Very High as a whole; however, at a leaf component level, ratings may vary considerably.
* TIME (Execution-Time Constraint) reflects the degree to which a system or component’s time performance is constrained by a combination of ASRs and design decisions. 

In the subsections that follow, and that precede the explanation of the second sub-step of Step 2 (Assigning default ratings for remaining COCOMO II parameters), we provide more detail on calculating WC and BC ratings for each of these parameters. We first discuss how software size for each leaf component is determined and the role REVL has in that determination.

### Determining a leaf component’s (unadjusted) software size from a guesstimate of total system size

As the purpose of Spotlight is to highlight areas of high uncertainty in an architectural specification, wherever they lie and no matter what the eventual size of the software component, Spotlight initially assigns the same software size to each leaf component and then rates and uses REVL to adjust that initial size estimate up to reflect the degree of uncertainty regarding future change. (In any case, an AADL model and Alisa ReqSpec file initially contain too little information by which to easily gauge software component size.)

Spotlight assumes a default size for the total system (constant Total_System_Size) of 10,000,000 Source Lines of code (written 10,000 KSLOC). As with other parameters assumed or assigned defaults by Spotlight, changing the default value for Total_System_Size is possible, but requires changing the declaration of the constant in the appropriate Java source file for Spotlight. 

Spotlight thus assigns an equal portion of this total system KSLOC to all leaf components of the selected AADL model instance. Thus:

Pre-adjusted size = Total_System_Size / numberLeaves.

### Detail on rating REVL and adjusting a leaf component’s estimated size

As REVL is a continuous-valued parameter in COCOMO II, while all 22 other parameters used by Spotlight are ordinal-valued, and given that the only basis for a component’s REVL rating is the set of 1-to-3 ordinal ratings of its associated ASRs, to keep how Spotlight approaches parameter ratings as uniform as possible, Spotlight likewise represents REVL on the same ordinal scale as the other 22 parameters. Thus, rather than represent REVL by a continuous percentage, REVL is rated on the same ordinal scale as the other 22 parameters (Very Low, Low, etc.). Each of these REVL rating levels is associated with a specific percentage by Spotlight, as described below. 

Spotlight adjusts the initial size it has calculated for each leaf component (previous subsection), with the appropriate best case (BC) and worst case (WC) REVL rating levels as follows:

For the Best Case (BC), the leaf component’s requirements will not evolve much and thus REVL is rated Very Low (5% change).

For the Worst Case (WC), Spotlight calculates the Median Volatility and Max Volatility of the ASRs allocated to the leaf component and then uses these to determine the REVL rating and value to use in order to adjust a leaf component’s size:

1. If Median Volatility is 3, then REVL is rated Very High (60%)
2. Else If Max Volatility is 3, then REVL is rated High (45%)
3. Else If Median Volatility is 2, then REVL is rated Nominal (30%)
4. Else If Max Volatility is 2, then REVL is rated Low (20%)
5. Otherwise, REVL is rated Very Low (5%)

Then, Adjusted size = Pre-adjusted size * (1 + REVL / 100). This increases the Pre-adjusted size (step 1) by REVL percent.

Applying the above to component c11: for BC, REVL is rated Very Low and thus adjusted size is (10,000/8) * 1.05 = 1,312.5 KSLOC. For WC, with ASR Volatility ratings of 1, 3, 2, 1, we obtain Median Volatility is 1.5 and Max Volatility is 3, and thus, REVL is rated High and the adjusted size for c11 is (10,000/8) * 1.45 = 1,812.5 KSLOC. (Throughout, we’ll show relatively high precision to allow the reader to follow along with the calculations, but of course many of these numbers are very imprecise; and thus only 2-3 digits are actually needed, throughout.)

### How might an architect improve what drives REVL ratings?

An architect can improve what drives REVL ratings by:

* Validating the requirements
* Revising the requirements to be more robust to change
* Following such analysis and revision, updating the ASRs’ volatility ratings in the ReqSpec file(s) accordingly

The use of Spotlight thus encourages early requirements discovery and their validation.

### Detail on rating PREC

Spotlight assigns best case (BC) and worst case (WC) PREC rating levels as follows:

In the Best Case (BC), there should be no surprises, and thus the rating for PREC is Very High (1.24). (We could have also rated Extremely High, but chose to assume some degree of novelty to the problem or solution.)

In the Worst Case (WC), Spotlight calculates the Median Precedented-ness of the ASRs allocated to the leaf component; and then uses this median value to determine the PREC rating level and value to use in the effort estimation formula:

1. If Median Precedented-ness is 1, then PREC is rated Very Low (6.20)
2. Else If Median Precedented-ness is 1.5, then PREC is rated Low (4.96) 
3. Else If Median Precedented-ness is 2, then PREC is rated Nominal (3.72)
4. Else If Max Precedented-ness is 2.5, then PREC is rated High (2.48)
5. Otherwise, PREC is rated Very High (1.24)

Applying the above to component c11: for BC, PREC is rated Very High (1.24). For WC, with ASR Precedented-ness ratings of 3, 2, 3, 1, we obtain Median Precedented-ness equal to 2.5, and thus, PREC is rated High (2.48).

### How might an architect improve what drives PREC ratings?

An architect can improve what drives PREC ratings by:

* Further decomposing the component into more tangible/specific subcomponents
* Searching for and matching to similar existing solutions
* A combination of the above.

Use of Spotlight thus encourages use of precedented solutions to the extent feasible.

### Detail on rating RELY

Spotlight assigns identical best case (BC) and worst case (WC) RELY rating levels. This is because Safety and Security concerns are seen as driving primarily system-level architectural solutions, which, if poorly selected, will result in many leaf components having high BC and WC ratings.

Thus, in both the Best Case (BC) and worst case (WC), Spotlight counts the number of Safety requirements allocated to that component and the number of Security requirements allocated to that component (some requirements may be both and increase both counts); and then uses these counts to determine the RELY rating level and value to use in the effort estimation formula:

1. If Safety count is greater than 0, then RELY is rated Very High (1.26)
2. Else If Security count is greater than 0, then RELY is High (1.10)
3. Otherwise, RELY is rated Nominal (1.00)

Applying the above to component c11: with Safety count of 2, we obtain for WC and BC, RELY is rated Very High (1.26). (Because there was at least one Safety requirement allocated to c11, its Security count did not matter.)

### How might an architect improve what drives RELY ratings?

An architect can improve what drives RELY ratings by:

* Re-allocating Safety and Security requirements to leaf components at a higher level of the architecture
* To minimize impact on safety, change the requirements and architecture to isolate the effects (and hazards) from some components’ failure to provide timely correct service
* To minimize impact on security, change the architecture or design to reduce the attack surface or thwart attempts to amass capabilities once an adversary has obtained access inside the system.

### Detail on rating CPLX

Spotlight assigns best case (BC) and worst case (WC) CPLX rating levels as follows:

Spotlight counts the number of Safety, Security, and Performance requirements allocated to that component (some requirements may increase more than one of these counts); and then uses these counts as follows to estimate the number of potential interactions constraining the available solution:

1. Calculate Safety/Security count = Safety count + Security count
2. Calculate BC Weight = (maximum of Safety/Security count and Performance count)+1
3. Calculate WC Weight = (Safety/Security count+1)*(Performance count+1)
4. For BC, calculate Root = square root of (BC Weight)
5. For WC, calculate Root = square root of (WC Weight)
6. (Above, we used the same variable Root for both BC and WC as the rest of the procedure is the same for both.)

Then, to determine the CPLX rating level and value to use in the effort estimation formula:

1. If Root is greater than or equal to 3.5, then CPLX is rated Extremely High (1.74)
2. Else If Root is greater than or equal to 3.0, then CPLX is rated Very High (1.34)
3. Else If Root is greater than or equal to 2.4, then CPLX is rated High (1.17)
4. Else If Root is greater than or equal to 2.0, then CPLX is rated Nominal (1.00)
5. Else If Root is greater than or equal to 1.5, then CPLX is rated Low (0.87)
6. Otherwise, CPLX is rated Very Low (0.73)

The 2.4 threshold mentioned above is not a typo. Consider this example: if the Safety/Security count is 2, and Performance count is 1, then setting the threshold at 2.5 would result in only a Nominal WC CPLX rating, which seems to be an underestimation. Thus, 2.4 was selected for the threshold. (In the same example, a threshold at 2.4 would result in a High CPLX rating.)

Applying the above to component c11: with Safety, Security, and Performance counts of 2, 1, and 3, respectively, we obtain: 

* Safety/Security count = 3
* BC Weight = (maximum of 3 and 3)+1 = 4
* WC Weight = (3+1)*(3+1) = 4*4
* For BC, Root = 2
* For WC, Root = 4

Therefore, for BC, CPLX is rated Nominal (1.00); whereas for WC, CPLX is rated Extremely High (1.74).

### How might an architect improve what drives CPLX ratings?

An architect can improve what drives CPLX ratings by:

* Selecting an architecture/design at the global level that better partitions concerns (e.g., requirements for safety and security versus performance)
* Selecting simpler designs and solutions at the leaf component level (which should be reflected in a decomposition of the original leaf component into subcomponents with less interaction among the newly-allocated and refined requirements)

### Detail on rating TIME

Spotlight assigns identical best case (BC) and worst case (WC) TIME rating levels. This is because Performance concerns are seen as driving primarily system-level architectural solutions; though not entirely, of course.

Thus, in both the Best Case (BC) and worst case (WC), Spotlight counts the number of Performance requirements allocated to that component; and then uses this count to determine the TIME rating level and value to use in the effort estimation formula:

1. If Performance count is greater than or equal to 3, then TIME is rated Extremely High (1.63)
2. Else If Performance count is 2, then TIME is rated Very High (1.29)
3. Else If Performance count is 1, then TIME is rated High (1.11)
4. Otherwise, TIME is rated Nominal (1.00)

Applying the above to component c11: with a Performance count of 3, we obtain for WC and BC, TIME is rated Extremely High (1.63).

### How might an architect improve what drives TIME ratings?

An architect can improve what drives TIME ratings by:

* Reallocating demands among software components for the computational infrastructure so that fewer leaf components have a multitude of performance requirements

Note that some actions taken to a feasible timing solution might or might not improve TIME ratings but should be considered regardless, including:

* Selecting a scheduling algorithm that has proven properties (e.g., Rate Monotonic Scheduling), which may help guide what kind of Performance requirements each leaf component should have (addressing the assumptions the scheduling algorithm makes about the timing and behavior of leaf components)
* Increasing the capacity and throughput of the computational infrastructure (may require renegotiating requirements)

There are limits to the effectiveness of the Spotlight analysis, and this is one of them. Perhaps a future version of Spotlight can assign ratings to TIME based on an analysis of the parent of the leaf component in the AADL model and how much capacity it has been allocated versus the demands of its subcomponents.

Having completed the description of how to obtain BC and WC ratings and values for effort estimation from specified attributes of the ASRs allocated to a leaf component, we’re now ready to describe the default ratings for the remaining COCOMO II parameters, which we do in the next section.

### Step 2.2. Assign default ratings for remaining COCOMO II parameters assuming a savvy development team

The second sub-step is to assign default ratings, which are associated with specific values in the COCOMO 2.0 Model Definition Manual, for the remaining 18 (4+14) COCOMO II parameters, assuming a capable and experienced developer team, knowledgeable in the particular embedded application domain, conversant with the appropriate tools and platforms, and having a capable software development process. The list of descriptions of how Spotlight addresses the 18 parameters is divided into these sub-lists: Scale Factors (these appear as a term in the exponent COCOMO II applies to software size, hence their name), Product Factors, Platform Factors, Personnel Factors, and Project Factors. 

The information about each parameter (factor) is organized as follows: four-letter name by which the parameter is known in COCOMO II, a full name for the parameter, a description of why the component is important to estimating effort, and the default rating assigned by Spotlight to all leaf components, project-wide, and for both WC and BC estimation.

First, appear the four scale factors FLEX, RESL, TEAM, and PMAT. (The fifth scale factor, PREC, is one of the five set by Spotlight based on an analysis of the component’s associated ReqSpec file, and is addressed in an earlier subsection.)

* FLEX (Flexibility relative to how goals are achieved) addresses how many deeply-reaching development process constraints and standards are likely to be imposed. Certification drives this to Rigorous. Thus, Spotlight rates FLEX to be Very Low (5.07).
* RESL (Adequacy of Risk Management) addresses the degree to which the project establishes and follows an adequately-resourced risk management plan with full attention to architectural risks and their mitigation. Spotlight rates RESL to be Very High (1.41).
* TEAM (Team Cooperativeness) addresses the degree of full stakeholder alignment and experience. Spotlight rates TEAM to be Very High (1.10).
* PMAT (CMM or CMMI Process Maturity) addresses the process maturity/capability of the development team. Spotlight rates this parameter High (3.12), which is typical of a solid Maturity Level 3 organization.

The next three parameters, DATA, RUSE, and DOCU, are three of the five so-called Product Factors. (The other two are RELY and CPLX, rated as described previously.) Spotlight rates all three Very High.

* DATA (Database Size): primarily reflects test database size; thus Spotlight rates Very High (1.28).
* RUSE (Developed for Reusability): Whether at the component level or for the system as a whole, a product-line development approach is likely to be pursued, and thus is rated Very High (1.15).
* DOCU (Documentation Match to Lifecycle Needs): primarily reflects the need for extensive design and coding documentation; and Spotlight rates Very High (1.23).

The next two parameters, STOR and PVOL, are two of the three so-called Platform Factors. The third factor is TIME, rated as described previously. All three factors refer to the computational infrastructure that the software calls on (can be: hardware only; hardware and operating system; hardware, operating system, and middle-ware; etc.).

* STOR (Main Storage Constraint): with the goal of maintaining as much orthogonality as possible across the information teased from a leaf component’s associated ReqSpec file, given that TIME is already governed by the number of Performance ASRs allocated to a component; STOR is simply assigned a default rating of Nominal (1.00).
* PVOL (Platform Volatility) is a measure of the volatility of the platform, that is, how often it changes. Perhaps, the rate at which bindings to processor, memory, and buses change in an AADL model specification signifies PVOL. But based only on a component’s requirements, Spotlight assigns a default rating of Very High (1.30).

The next six effort multipliers (ACAP, PCAP, PCON, APEX, PLEX, LTEX) are Personnel Factors. They reflect development team capability, continuity (team member retention), and experience. While these ratings are likely to change in the course of a project and from component to component we will assume these factors are all Project-wide and rated Very High (the values corresponding to Very High ratings for these six parameters are: 0.71, 0.76, 0.81, 0.81, 0.85, and 0.84, respectively).

The final three effort multipliers (TOOL, SITE, SCED) are Project Factors; and they are described below.

* TOOL (Use of Software Tools) addresses the capability of the software tools used. While the architecting of components might involve different software tools (e.g., for testing, static analyses, simulation), Spotlight treats this parameter as a Project-wide parameter that should be rated Very High (0.78), given the domain.
* SITE (Site Collocation and Communication) addresses whether there is a need for “Multi-site Development;” and Spotlight rates as High (0.93).
* SCED (Schedule Compression): Represents the degree to which the development schedule is constrained. Spotlight rates this parameter as Nominal (1.00), indicating there is reasoned pressure to deliver full capability soon, but not unreasonably soon.

### Step 2.3. Apply the COCOMO II effort estimation formula

We first summarize the steps for applying the COCOMO II effort estimation formula, described in the COCOMO 2.0 Model Definition Manual, but simplified here due to the assignment to 4 of the 5 scale factors and to 14 of the 17 effort multipliers project-wide default ratings by Spotlight. Then we apply the simplified formula to calculate BC and WC for component c11.

We show the simplification in formula form, using the notation X_Z to represent the value that COCOMO II gives for Level Y of parameter X; where Y is the rating level (Very Low, Low, Nominal, etc.) calculated or assigned by Spotlight for parameter X (four-character parameter name) for the Z development scenario (Z is either BC or WC). We will sometimes use X_Z to represent the Spotlight assigned rating level, and other times the unique value that COCOMO 2.0 Model Definition Manual assigns that X_Z rating level. (There’s a one-to-one correspondence between the two, so this should not be too confusing.) Here is the detail of the effort estimation formula simplification:

* Sum of Spotlight-assigned default values for 4 of the 5 scale factors (FLEX, RESL, TEAM, and PMAT) = 5.07 + 1.41 + 1.10 + 3.12 = 10.70.
* Using our X_Z notation, the Spotlight-calculated PREC scale factor for BC = PREC_BC; and for WC = PREC_WC.
* The exponent in the COCOMO II effort formula is the sum of the values in the previous two bullets, divided by 100, with the COCOMO II effort estimation constant B as defined in COCOMO 2.0 Model Definition Manual, which equals 0.91 (uncalibrated); thus for BC, the exponent = 1.0170 + (PREC_BC/100); and for WC, the exponent = 1.0170 + (PREC_WC/100);
* Product of Spotlight-set default values for 3 of the 5 Product Factors (DATA, RUSE, and DOCU) = 1.28 * 1.15 * 1.23 = 1.8106
* Product of Spotlight-set default values for 2 of the 3 Platform Factors (STOR and PVOL) = 1.00 * 1.30 = 1.30
* Product of Spotlight-set default values for all 6 Personnel Factors (ACAP, PCAP, PCON, APEX, PLEX, LTEX) = 0.71 * 0.76 * 0.81 * 0.81 * 0.85 * 0.84 = 0.2528
* Product of Spotlight-set default values for all 3 Project Factors (TOOL, SITE, SCED) = 0.78 * 0.93 * 1.00 = 0.7254
* Thus, product of all 14 of the 17 parameters categorized as effort multipliers (also known as cost drivers) = 1.8106 * 1.30 * 0.2528 * 0.7254 = 0.4316.
* Then, including the Spotlight-calculated effort multipliers (RELY, CPLX, and TIME), we obtain this grand product of effort multipliers: for BC, the grand product = 0.4316 * RELY_BC * CPLX_BC * TIME_BC; and for WC, the grand product = 0.4316 * RELY_WC * CPLX_WC * TIME_WC.
* Let n = the number of leaf components (n=8 in our example). Then we obtain an unadjusted software size for a leaf component = 10,000/n KSLOC; and thus this for the adjusted software size: for BC, size = 10,500/n KSLOC (because, regardless of the ASRs allocated to a leaf component, Spotlight rates REVL_BC Very Low (5%)); and for WC, size = (10,000/n) * (1+(REVL_WC/100)).
* Then, the effort estimate, in person months, is the result of raising the adjusted software size by the calculated exponent; multiplying the resulting power by both the grand product of effort multipliers (three bullets back) and by the COCOMO II effort estimation constant A as defined in COCOMO 2.0 Model Definition Manual, which equals 2.94 (uncalibrated). We give the resulting formulas in the next two bullets.
* For BC, the effort is estimated to be 2.94 * ((10,500/n) ^ (1.0170+(PREC_BC/100))) * (0.4316 * RELY_BC * CPLX_BC * TIME_BC).
* For WC, the effort is estimated to be 2.94 * (((10,000/n) * (1+(REVL_WC/100))) ^ (1.0170+(PREC_WC/100))) * (0.4316 * RELY_WC * CPLX_WC * TIME_WC).

In the case of our c11 example, we have these values for the Spotlight-calculated parameters: n=8; REVL_WC = 45%; PREC_BC = 1.24 and PREC_WC = 2.48; RELY_BC = RELY_WC = 1.26; CPLX_BC = 1.00 and CPLX_WC = 1.74; and TIME_BC = TIME_WC = 1.63. Therefore, plugging these values into the previous two bullets:

* For BC, the effort for c11 is estimated to be 2.94 * (1,312.5 ^ 1.0294) * (0.4316 * (1.26 * 1.00 * 1.63)) = 4,234 (approx.).
* For WC, the effort for c11 is estimated to be 2.94 * (1,812.5 ^ 1.0418) * (0.4316 * (1.26 * 1.74 * 1.63)) = 11,246 (approx.).

### Step 3. Compute the Potential-for-Uncertainty-Resolution (PUR).

This is simply the difference between the WC estimate of effort and BC estimate of effort. Then, having computed PUR for every leaf component, Spotlight displays the leaf components sorted by PUR, in decreasing size.

For example, in the case of the c11 component, we have PUR = 11,246 - 4,234 = 7,012 person months, approximately, which agrees reasonably well with the Spotlight-calculated PUR shown in the screenshot.

## Benefits of using Spotlight

The benefits accrued from using Spotlight were already touched on in earlier sections, but in this last section, we consider the benefits in the larger framing of what Alisa is intended to help accomplish.


Alisa’s goal is to help the architect rapidly develop an architecture that includes correct and complete:

* Requirements covering both nominal and exceptional conditions
* Verification, including plans for, and results from, evaluating an AADL model (or model component) against specific requirements
* Assurance case organizing the results of verifications into an argument that requirements are met by an AADL model.

Alisa Framework already provides much help for detecting:

* Defects, inconsistencies, and missing information, which threaten the validity of judgments made.

Thus, the Alisa Framework helps the architect model an effective software-dependent system architecture for a carefully analyzed, refined, and co-developed set of requirements.

In the above context, the goal for Spotlight is to leverage Alisa, more specifically, the information in Alisa ReqSpec files, in order to guide the architect to components requiring attention. 

The benefit? Paying early attention to the high-uncertainty areas increases stability of decisions and reduces rework; and allows earlier identification and mitigation of issues and risks, both in architecting specifically, but more broadly in system development.

