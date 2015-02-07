package com.cymbocha.apis.testrail;

import com.cymbocha.apis.testrail.internal.ListToCsvSerializer;
import com.cymbocha.apis.testrail.model.*;
import com.fasterxml.jackson.annotation.JsonView;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.*;
import lombok.experimental.Accessors;

import java.util.Date;
import java.util.List;
import java.util.Map;

import static com.google.common.base.Preconditions.checkArgument;

/**
 * Client for Test Rail API. Configure and use it to create requests for the API.
 *
 * @author kms
 * @see <a href="http://docs.gurock.com/testrail-api2/start">TestRail API v2 Documentation</a>
 */
@AllArgsConstructor
public class TestRail {

    private final TestRailConfig config;

    /**
     * An accessor for creating requests for "Projects".
     *
     * @return a request factory
     */
    public Projects projects() {
        return new Projects();
    }

    /**
     * An accessor for creating requests for "Cases".
     *
     * @return a request factory
     */
    public Cases cases() {
        return new Cases();
    }

    /**
     * An accessor for creating requests for "Case Fields".
     *
     * @return a request factory
     */
    public CaseFields caseFields() {
        return new CaseFields();
    }

    /**
     * An accessor for creating requests for "Case Types".
     *
     * @return a request factory
     */
    public CaseTypes caseTypes() {
        return new CaseTypes();
    }

    /**
     * An accessor for creating requests for "Configurations".
     *
     * @return a request factory
     */
    public Configurations configurations() {
        return new Configurations();
    }

    /**
     * An accessor for creating requests for "Sections".
     *
     * @return a request factory
     */
    public Sections sections() {
        return new Sections();
    }

    /**
     * An accessor for creating requests for "Suites".
     *
     * @return a request factory
     */
    public Suites suites() {
        return new Suites();
    }

    /**
     * An accessor for creating requests for "Milestones".
     *
     * @return a request factory
     */
    public Milestones milestones() {
        return new Milestones();
    }

    /**
     * An accessor for creating requests for "Priorities".
     *
     * @return a request factory
     */
    public Priorities priorities() {
        return new Priorities();
    }

    /**
     * An accessor for creating requests for "Result Fields".
     *
     * @return a request factory
     */
    public ResultFields resultFields() {
        return new ResultFields();
    }

    /**
     * An accessor for creating requests for "Tests".
     *
     * @return a request factory
     */
    public Tests tests() {
        return new Tests();
    }

    /**
     * An accessor for creating requests for "Users".
     *
     * @return a request factory
     */
    public Users users() {
        return new Users();
    }

    /**
     * An accessor for creating requests for "Statuses".
     *
     * @return a request factory
     */
    public Statuses statuses() {
        return new Statuses();
    }

    /**
     * An accessor for creating requests for "Runs".
     *
     * @return a request factory
     */
    public Runs runs() {
        return new Runs();
    }

    /**
     * An accessor for creating requests for "Plans".
     *
     * @return a request factory
     */
    public Plans plans() {
        return new Plans();
    }

    /**
     * An accessor for creating requests for "Results".
     *
     * @return a request factory
     */
    public Results results() {
        return new Results();
    }

    /**
     * Request factories for "Projects".
     */
    @NoArgsConstructor(access = AccessLevel.PRIVATE)
    public class Projects {

        /**
         * Returns an existing project.
         *
         * @param projectId the ID of the project
         * @return the request
         * @throws java.lang.IllegalArgumentException if projectId is not positive
         */
        public Get get(final int projectId) {
            checkArgument(projectId > 0, "projectId should be positive");
            return new Get(projectId);
        }

        /**
         * Returns the list of available projects.
         *
         * @return the request
         */
        public List list() {
            return new List();
        }

        /**
         * Creates a new project.
         *
         * @param project the project to be added
         * @return the request
         * @throws java.lang.NullPointerException if project is null
         */
        public Add add(@NonNull Project project) {
            return new Add(project);
        }

        /**
         * Updates an existing project. Partial updates are supported, i.e. you can set and update specific fields only.
         *
         * @param project the project to be updated
         * @return the request
         * @throws java.lang.NullPointerException if project is null
         */
        public Update update(@NonNull Project project) {
            return new Update(project);
        }

        /**
         * Deletes an existing project.
         *
         * @param project the project to be deleted
         * @return the request
         * @throws java.lang.NullPointerException if project is null
         */
        public Delete delete(@NonNull Project project) {
            return new Delete(project);
        }

        public class Get extends Request<Project> {
            private static final String REST_PATH = "get_project/";

            private Get(int projectId) {
                super(config, Method.GET, REST_PATH + projectId, Project.class);
            }
        }

        public class List extends Request<java.util.List<Project>> {
            private static final String REST_PATH = "get_projects";

            private List() {
                super(config, Method.GET, REST_PATH, new TypeReference<java.util.List<Project>>() {
                });
            }
        }

        public class Add extends Request<Project> {
            private static final String REST_PATH = "add_project";

            private final Project project;

            private Add(@NonNull Project project) {
                super(config, Method.POST, REST_PATH, Project.class);
                this.project = project;
            }

            @Override
            protected Object getContent() {
                return project;
            }

        }

        public class Update extends Request<Project> {
            private static final String REST_PATH = "update_project/";

            private final Project project;

            private Update(@NonNull Project project) {
                super(config, Method.POST, REST_PATH + project.getId(), Project.class);
                this.project = project;
            }

            @Override
            protected Object getContent() {
                return project;
            }

        }

        public class Delete extends Request<Void> {
            private static final String REST_PATH = "delete_project/";

            private final Project project;

            private Delete(@NonNull Project project) {
                super(config, Method.POST, REST_PATH + project.getId(), Void.class);
                this.project = project;
            }

        }
    }

    /**
     * Request factories for "Cases".
     */
    @NoArgsConstructor(access = AccessLevel.PRIVATE)
    public class Cases {

        /**
         * Returns an existing test case.
         *
         * @param testCaseId the ID of the test case
         * @return the request
         * @throws java.lang.IllegalArgumentException if testCaseId is not positive
         */
        public Get get(final int testCaseId) {
            checkArgument(testCaseId > 0, "testCaseId should be positive");
            return new Get(testCaseId);
        }

        /**
         * Returns the list of available test cases.
         *
         * @param projectId the ID of the project which is operating in a single suite mode
         * @return the request
         * @throws java.lang.IllegalArgumentException if projectId is not positive
         */
        public List list(final int projectId) {
            checkArgument(projectId > 0, "projectId should be positive");
            return new List(projectId);
        }

        /**
         * Returns the list of available test cases.
         *
         * @param projectId the ID of the project
         * @param suiteId the ID of the suite
         * @return the request
         * @throws java.lang.IllegalArgumentException if any argument is not positive
         */
        public List list(final int projectId, final int suiteId) {
            checkArgument(projectId > 0, "projectId should be positive");
            checkArgument(suiteId > 0, "suiteId should be positive");
            return new List(projectId, suiteId);
        }

        /**
         * Creates a new test case.
         *
         * @param testCase the test case to be added
         * @return the request
         * @throws java.lang.NullPointerException if testCase is null
         */
        public Add add(@NonNull Case testCase) {
            return new Add(testCase);
        }

        /**
         * Updates an existing test case. Partial updates are supported, i.e. you can set and update specific fields only.
         *
         * @param testCase the test case to be updated
         * @return the request
         * @throws java.lang.NullPointerException if testCase is null
         */
        public Update update(@NonNull Case testCase) {
            return new Update(testCase);
        }

        /**
         * Deletes an existing test case.
         *
         * @param testCase the test case to be deleted
         * @return the request
         * @throws java.lang.NullPointerException if testCase is null
         */
        public Delete delete(@NonNull Case testCase) {
            return new Delete(testCase);
        }

        public class Get extends Request<Case> {
            private static final String REST_PATH = "get_case/";

            private Get(int testCaseId) {
                super(config, Method.GET, REST_PATH + testCaseId, Case.class);
            }
        }

        @Getter
        @Setter
        @Accessors(fluent = true)
        public class List extends Request<java.util.List<Case>> {
            private static final String REST_PATH = "get_cases/%s&suite_id=%s";

            @JsonView(List.class)
            private Integer sectionId;

            @JsonView(List.class)
            private Date createdAfter;

            @JsonView(List.class)
            private Date createdBefore;

            @JsonView(List.class)
            @JsonSerialize(using = ListToCsvSerializer.class)
            private java.util.List<Integer> createdBy;

            @JsonView(List.class)
            @JsonSerialize(using = ListToCsvSerializer.class)
            private java.util.List<Integer> milestoneId;

            @JsonView(List.class)
            @JsonSerialize(using = ListToCsvSerializer.class)
            private java.util.List<Integer> priorityId;

            @JsonView(List.class)
            @JsonSerialize(using = ListToCsvSerializer.class)
            private java.util.List<Integer> typeId;

            @JsonView(List.class)
            private Date updatedAfter;

            @JsonView(List.class)
            private Date updatedBefore;

            @JsonView(List.class)
            @JsonSerialize(using = ListToCsvSerializer.class)
            private java.util.List<Integer> updatedBy;

            private List(int projectId) {
                super(config, Method.GET, String.format(REST_PATH, projectId, ""), new TypeReference<java.util.List<Case>>() {});
            }

            private List(int projectId, int suiteId) {
                super(config, Method.GET, String.format(REST_PATH, projectId, suiteId), new TypeReference<java.util.List<Case>>() {});
            }

        }

        public class Add extends Request<Case> {
            private static final String REST_PATH = "add_case/";

            private final Case testCase;

            private Add(Case testCase) {
                super(config, Method.POST, REST_PATH + testCase.getSectionId(), Case.class);
                this.testCase = testCase;
            }

            @Override
            protected Object getContent() {
                return testCase;
            }

        }

        public class Update extends Request<Case> {
            private static final String REST_PATH = "update_case/";

            private final Case testCase;

            private Update(Case testCase) {
                super(config, Method.POST, REST_PATH + testCase.getId(), Case.class);
                this.testCase = testCase;
            }

            @Override
            protected Object getContent() {
                return testCase;
            }

        }

        public class Delete extends Request<Void> {
            private static final String REST_PATH = "delete_case/";

            private Delete(Case testCase) {
                super(config, Method.POST, REST_PATH + testCase.getId(), Void.class);
            }
        }
    }

    /**
     * Request factories for "Case Fields".
     */
    @NoArgsConstructor
    public class CaseFields {

        /**
         * Returns a list of available test case custom fields.
         *
         * @return the request
         */
        public List list() {
            return new List();
        }

        public class List extends Request<java.util.List<CaseField>> {
            private static final String REST_PATH = "get_case_fields";

            private List() {
                super(config, Method.GET, REST_PATH, new TypeReference<java.util.List<CaseField>>() {
                });
            }
        }
    }

    /**
     * Request factories for "Case Types".
     */
    @NoArgsConstructor
    public class CaseTypes {

        /**
         * Returns a list of available case types.
         *
         * @return the request
         */
        public List list() {
            return new List();
        }

        public class List extends Request<java.util.List<CaseType>> {
            private static final String REST_PATH = "get_case_types";

            private List() {
                super(config, Method.GET, REST_PATH, new TypeReference<java.util.List<CaseType>>() {
                });
            }
        }

    }

    /**
     * Request factories for "Configurations".
     */
    @NoArgsConstructor
    public class Configurations {

        /**
         * Returns a list of available configurations, grouped by configuration groups.
         *
         * @param project the project to get the configurations for
         * @return the request
         * @throws java.lang.NullPointerException if project is null
         */
        public List list(@NonNull Project project) {
            return new List(project);
        }

        public class List extends Request<java.util.List<Configuration>> {
            private static final String REST_PATH = "get_configs/";

            private List(Project project) {
                super(config, Method.GET, REST_PATH + project.getId(), new TypeReference<java.util.List<Configuration>>() {
                });
            }

        }

    }

    /**
     * Request factories for "Milestones".
     */
    @NoArgsConstructor
    public class Milestones {

        /**
         * Returns an existing milestone.
         *
         * @param milestoneId the ID of the milestone
         * @return the request
         * @throws java.lang.IllegalArgumentException if milestoneId is not positive
         */
        public Get get(final int milestoneId) {
            checkArgument(milestoneId > 0, "milestoneId should be positive");
            return new Get(milestoneId);
        }

        /**
         * Returns the list of milestones for a project.
         *
         * @param project the project to get the milestones for
         * @return the request
         * @throws java.lang.NullPointerException if project is null
         */
        public List list(@NonNull Project project) {
            return new List(project);
        }

        /**
         * Creates a new milestone.
         *
         * @param milestone the milestone to be added
         * @return the request
         * @throws java.lang.NullPointerException if milestone is null
         */
        public Add add(@NonNull Milestone milestone) {
            return new Add(milestone);
        }

        /**
         * Updates an existing milestone. Partial updates are supported, i.e. you can set and update specific fields only.
         *
         * @param milestone the milestone to be updated
         * @return the request
         * @throws java.lang.NullPointerException if milestone is null
         */
        public Update update(@NonNull Milestone milestone) {
            return new Update(milestone);
        }

        /**
         * Deletes an existing milestone.
         *
         * @param milestone the milestone to be deleted
         * @return the request
         * @throws java.lang.NullPointerException if milestone is null
         */
        public Delete delete(@NonNull Milestone milestone) {
            return new Delete(milestone);
        }

        public class Get extends Request<Milestone> {
            private static final String REST_PATH = "get_milestone/";

            private Get(int milestoneId) {
                super(config, Method.GET, REST_PATH + milestoneId, Milestone.class);
            }
        }

        public class List extends Request<java.util.List<Milestone>> {
            private static final String REST_PATH = "get_milestones/";

            private List(Project project) {
                super(config, Method.GET, REST_PATH + project.getId(), new TypeReference<java.util.List<Milestone>>() {
                });
            }
        }

        public class Add extends Request<Milestone> {
            private static final String REST_PATH = "add_milestone/";

            private final Milestone milestone;

            private Add(Milestone milestone) {
                super(config, Method.POST, REST_PATH + milestone.getProjectId(), Milestone.class);
                this.milestone = milestone;
            }

            @Override
            protected Object getContent() {
                return milestone;
            }
        }

        public class Update extends Request<Milestone> {
            private static final String REST_PATH = "update_milestone/";

            private final Milestone milestone;

            private Update(Milestone milestone) {
                super(config, Method.POST, REST_PATH + milestone.getId(), Milestone.class);
                this.milestone = milestone;
            }

            @Override
            protected Object getContent() {
                return milestone;
            }
        }

        public class Delete extends Request<Void> {
            private static final String REST_PATH = "delete_milestone/";

            private Delete(Milestone milestone) {
                super(config, Method.POST, REST_PATH + milestone.getId(), Void.class);
            }
        }

    }

    /**
     * Request factories for "Priorities".
     */
    @NoArgsConstructor
    public class Priorities {

        /**
         * Returns a list of available priorities.
         *
         * @return the request
         */
        public List list() {
            return new List();
        }

        public class List extends Request<java.util.List<Priority>> {
            private static final String REST_PATH = "get_priorities";

            private List() {
                super(config, Method.GET, REST_PATH, new TypeReference<java.util.List<Priority>>() {
                });
            }
        }

    }

    /**
     * Request factories for "Plans".
     */
    @NoArgsConstructor
    public class Plans {

        /**
         * Returns an existing test plan.
         *
         * @param planId the ID of the test plan
         * @return the request
         * @throws java.lang.IllegalArgumentException if planId is not positive
         */
        public Get get(final int planId) {
            checkArgument(planId > 0, "planId should be positive");
            return new Get(planId);
        }

        /**
         * Returns a list of test plans for a project.
         *
         * @param project the project to get the test plans for
         * @return the request
         * @throws java.lang.NullPointerException if project is null
         */
        public List list(@NonNull Project project) {
            return new List(project);
        }

        /**
         * Creates a new test plan.
         *
         * @param plan the test plan to be added
         * @return the request
         * @throws java.lang.NullPointerException if plan is null
         */
        public Add add(@NonNull Plan plan) {
            return new Add(plan);
        }

        /**
         * Updates an existing test plan. Partial updates are supported, i.e. you can set and update specific fields only.
         *
         * @param plan the test plan to be updated
         * @return the request
         * @throws java.lang.NullPointerException if plan is null
         */
        public Update update(@NonNull Plan plan) {
            return new Update(plan);
        }

        /**
         * Closes an existing test plan and archives its test runs & results.
         *
         * @param plan the test plan to be closed
         * @return the request
         * @throws java.lang.NullPointerException if plan is null
         */
        public Close close(@NonNull Plan plan) {
            return new Close(plan);
        }

        /**
         * Deletes an existing test plan.
         *
         * @param plan the test plan to be deleted
         * @return the request
         * @throws java.lang.NullPointerException if plan is null
         */
        public Delete delete(@NonNull Plan plan) {
            return new Delete(plan);
        }

        /**
         * Adds one or more new test runs to a test plan.
         *
         * @param plan  the test plan to add the entry to
         * @param entry the plan entry to be added
         * @return the request
         * @throws java.lang.NullPointerException if any argument is null
         */
        public AddEntry addEntry(@NonNull Plan plan, @NonNull Plan.Entry entry) {
            return new AddEntry(plan, entry);
        }

        /**
         * Updates one or more existing test runs in a plan. Partial updates are supported, i.e. you can set and update specific fields only.
         *
         * @param plan  the test plan to update the entry in
         * @param entry the plan entry to be updated
         * @return the request
         * @throws java.lang.NullPointerException if any argument is null
         */
        public UpdateEntry updateEntry(@NonNull Plan plan, @NonNull Plan.Entry entry) {
            return new UpdateEntry(plan, entry);
        }

        /**
         * Deletes one or more existing test runs from a plan.
         *
         * @param plan  the test plan to delete entry from
         * @param entry the plan entry to be deleted
         * @return the request
         * @throws java.lang.NullPointerException if any argument is null
         */
        public DeleteEntry deleteEntry(@NonNull Plan plan, @NonNull Plan.Entry entry) {
            return new DeleteEntry(plan, entry);
        }

        public class Get extends Request<Plan> {
            private static final String REST_PATH = "get_plan/";

            private Get(int planId) {
                super(config, Method.GET, REST_PATH + planId, Plan.class);
            }
        }

        public class List extends Request<java.util.List<Plan>> {
            private static final String REST_PATH = "get_plans/";

            private List(Project project) {
                super(config, Method.GET, REST_PATH + project.getId(), new TypeReference<java.util.List<Plan>>() {
                });
            }
        }

        public class Add extends Request<Plan> {
            private static final String REST_PATH = "add_plan/";

            private final Plan plan;

            private Add(Plan plan) {
                super(config, Method.POST, REST_PATH + plan.getProjectId(), Plan.class);
                this.plan = plan;
            }

            @Override
            protected Object getContent() {
                return plan;
            }
        }

        public class AddEntry extends Request<Plan.Entry> {
            private static final String REST_PATH = "add_plan_entry/";

            private final Plan.Entry entry;

            private AddEntry(Plan plan, Plan.Entry entry) {
                super(config, Method.POST, REST_PATH + plan.getId(), Plan.Entry.class);
                this.entry = entry;
            }

            @Override
            protected Object getContent() {
                return entry;
            }
        }

        public class Update extends Request<Plan> {
            private static final String REST_PATH = "update_plan/";

            private final Plan plan;

            private Update(Plan plan) {
                super(config, Method.POST, REST_PATH + plan.getId(), Plan.class);
                this.plan = plan;
            }

            @Override
            protected Object getContent() {
                return plan;
            }
        }

        public class UpdateEntry extends Request<Plan.Entry> {
            private static final String REST_PATH = "update_plan_entry/%s/%s";

            private final Plan.Entry entry;

            private UpdateEntry(Plan plan, Plan.Entry entry) {
                super(config, Method.POST, String.format(REST_PATH, plan.getId(), entry.getId()), Plan.Entry.class);
                this.entry = entry;
            }

            @Override
            protected Object getContent() {
                return entry;
            }
        }

        public class Close extends Request<Plan> {
            private static final String REST_PATH = "close_plan/";

            private Close(Plan plan) {
                super(config, Method.POST, REST_PATH + plan.getId(), Plan.class);
            }
        }

        public class Delete extends Request<Void> {
            private static final String REST_PATH = "delete_plan/";

            private Delete(Plan plan) {
                super(config, Method.POST, REST_PATH + plan.getId(), Void.class);
            }
        }

        public class DeleteEntry extends Request<Void> {
            private static final String REST_PATH = "delete_plan_entry/%s/%s";

            private DeleteEntry(Plan plan, Plan.Entry entry) {
                super(config, Method.POST, String.format(REST_PATH, plan.getId(), entry.getId()), Void.class);
            }
        }
    }

    /**
     * Request factories for "Results".
     */
    @NoArgsConstructor
    public class Results {

        /**
         * Returns a list of test results for a test.
         *
         * @param test the test to get the results for
         * @return the request
         * @throws java.lang.NullPointerException if test is null
         */
        public List list(@NonNull Test test) {
            return new List(test);
        }

        /**
         * Returns a list of test results for a test run and case combination.
         *
         * @param run      the test run
         * @param testCase the test case
         * @return the request
         * @throws java.lang.NullPointerException if any argument is null
         */
        public ListForCase list(@NonNull Run run, @NonNull Case testCase) {
            return new ListForCase(run, testCase);
        }

        /**
         * Returns a list of test results for a test run.
         *
         * @param run the test run to get the results for
         * @return the request
         * @throws java.lang.NullPointerException if run is null
         */
        public ListForRun list(@NonNull Run run) {
            return new ListForRun(run);
        }

        /**
         * Adds a new test result, comment or assigns a test.
         *
         * @param result the test result to be added
         * @return the request
         * @throws java.lang.NullPointerException if result is null
         */
        public Add add(@NonNull Result result) {
            return new Add(result);
        }

        /**
         * Adds a new test result, comment or assigns a test (for a test run and case combination).
         *
         * @param run      the test run
         * @param testCase the test case
         * @param result   the test result to be added
         * @return the request
         * @throws java.lang.NullPointerException if any argument is null
         */
        public AddForCase add(@NonNull Run run, @NonNull Case testCase, @NonNull Result result) {
            return new AddForCase(run, testCase, result);
        }

        /**
         * Adds one or more new test results, comments or assigns one or more tests.
         *
         * @param run     the test run to add the results to
         * @param results the test results to be added
         * @return the request
         * @throws java.lang.NullPointerException     if any argument is null
         * @throws java.lang.IllegalArgumentException if results is empty
         */
        public AddList add(@NonNull Run run, @NonNull java.util.List<Result> results) {
            checkArgument(!results.isEmpty(), "results cannot be empty");
            return new AddList(run, results);
        }

        /**
         * Adds one or more new test results, comments or assigns one or more tests (using the case IDs).
         *
         * @param run     the test run to add the results to
         * @param results the test results to be added
         * @return the request
         * @throws java.lang.NullPointerException     if any argument is null
         * @throws java.lang.IllegalArgumentException if results is empty
         */
        public AddListForCases addForCases(@NonNull Run run, @NonNull java.util.List<Result> results) {
            checkArgument(!results.isEmpty(), "results cannot be empty");
            return new AddListForCases(run, results);
        }

        public class List extends Request<java.util.List<Result>> {
            private static final String REST_PATH = "get_results/";

            private List(Test test) {
                super(config, Method.GET, REST_PATH + test.getId(), new TypeReference<java.util.List<Result>>() {
                });
            }
        }

        public class ListForRun extends Request<java.util.List<Result>> {
            private static final String REST_PATH = "get_results_for_run/";

            private ListForRun(Run run) {
                super(config, Method.GET, REST_PATH + run.getId(), new TypeReference<java.util.List<Result>>() {
                });
            }
        }

        public class ListForCase extends Request<java.util.List<Result>> {
            private static final String REST_PATH = "get_results_for_case/";

            private ListForCase(Run run, Case testCase) {
                super(config, Method.GET, REST_PATH + run.getId() + "/" + testCase.getId(), new TypeReference<java.util.List<Result>>() {
                });
            }
        }

        public class Add extends Request<Result> {
            private static final String REST_PATH = "add_result/";

            private final Result result;

            private Add(Result result) {
                super(config, Method.POST, REST_PATH + result.getTestId(), Result.class);
                this.result = result;
            }

            @Override
            protected Object getContent() {
                return result;
            }
        }

        public class AddForCase extends Request<Result> {
            private static final String REST_PATH = "add_result_for_case/";

            private final Result result;

            private AddForCase(Run run, Case testCase, Result result) {
                super(config, Method.POST, REST_PATH + run.getId() + "/" + testCase.getId(), Result.class);
                this.result = result;
            }

            @Override
            protected Object getContent() {
                return result;
            }
        }

        public class AddList extends Request<java.util.List<Result>> {
            private static final String REST_PATH = "add_results/";

            private final Result.List results;

            private AddList(Run run, java.util.List<Result> results) {
                super(config, Method.POST, REST_PATH + run.getId(), new TypeReference<java.util.List<Result>>() {
                });
                this.results = new Result.List(results);
            }

            @Override
            protected Object getContent() {
                return results;
            }
        }

        public class AddListForCases extends Request<java.util.List<Result>> {
            private static final String REST_PATH = "add_results_for_cases/";

            private final Result.List results;

            private AddListForCases(Run run, java.util.List<Result> results) {
                super(config, Method.POST, REST_PATH + run.getId(), new TypeReference<java.util.List<Result>>() {
                });
                this.results = new Result.List(results);
            }

            @Override
            protected Object getContent() {
                return results;
            }
        }

    }


    /**
     * Request factories for "Result Fields".
     */
    @NoArgsConstructor
    public class ResultFields {

        /**
         * Returns a list of available test result custom fields.
         *
         * @return the request
         */
        public List list() {
            return new List();
        }

        public class List extends Request<java.util.List<ResultField>> {
            private static final String REST_PATH = "get_result_fields";

            private List() {
                super(config, Method.GET, REST_PATH, new TypeReference<java.util.List<ResultField>>() {
                });
            }
        }
    }

    /**
     * Request factories for "Runs".
     */
    @NoArgsConstructor
    public class Runs {

        /**
         * Returns an existing test run.
         *
         * @param runId the ID of the test run
         * @return the request
         * @throws java.lang.IllegalArgumentException if runId is not positive
         */
        public Get get(final int runId) {
            checkArgument(runId > 0, "runId should be positive");
            return new Get(runId);
        }

        /**
         * Returns a list of test runs for a project. Only returns those test runs that are not part of a test plan.
         *
         * @param project the project to get the test runs for
         * @return the request
         * @throws java.lang.NullPointerException if project is null
         */
        public List list(@NonNull Project project) {
            return new List(project);
        }

        /**
         * Creates a new test run.
         *
         * @param run the test run to be added
         * @return the request
         * @throws java.lang.NullPointerException if run is null
         */
        public Add add(@NonNull Run run) {
            return new Add(run);
        }

        /**
         * Updates an existing test run. Partial updates are supported, i.e. you can set and update specific fields only.
         *
         * @param run the test run to be updated
         * @return the request
         * @throws java.lang.NullPointerException if run is null
         */
        public Update update(@NonNull Run run) {
            return new Update(run);
        }

        /**
         * Closes an existing test run and archives its tests & results.
         *
         * @param run the test run to be closed
         * @return the request
         * @throws java.lang.NullPointerException if run is null
         */
        public Close close(@NonNull Run run) {
            return new Close(run);
        }

        /**
         * Deletes an existing test run.
         *
         * @param run the test run to be deleted
         * @return the request
         * @throws java.lang.NullPointerException if run is null
         */
        public Delete delete(@NonNull Run run) {
            return new Delete(run);
        }

        public class Get extends Request<Run> {
            private static final String REST_PATH = "get_run/";

            private Get(int runId) {
                super(config, Method.GET, REST_PATH + runId, Run.class);
            }
        }

        public class List extends Request<java.util.List<Run>> {
            private static final String REST_PATH = "get_runs/";

            private List(Project project) {
                super(config, Method.GET, REST_PATH + project.getId(), new TypeReference<java.util.List<Run>>() {
                });
            }
        }

        public class Add extends Request<Run> {
            private static final String REST_PATH = "add_run/";

            private final Run run;

            private Add(Run run) {
                super(config, Method.POST, REST_PATH + run.getProjectId(), Run.class);
                this.run = run;
            }

            @Override
            protected Object getContent() {
                return run;
            }
        }

        public class Update extends Request<Run> {
            private static final String REST_PATH = "update_run/";

            private final Run run;

            private Update(Run run) {
                super(config, Method.POST, REST_PATH + run.getId(), Run.class);
                this.run = run;
            }

            @Override
            protected Object getContent() {
                return run;
            }
        }

        public class Close extends Request<Run> {
            private static final String REST_PATH = "close_run/";

            private Close(Run run) {
                super(config, Method.POST, REST_PATH + run.getId(), Run.class);
            }
        }

        public class Delete extends Request<Void> {
            private static final String REST_PATH = "delete_run/";

            private Delete(Run run) {
                super(config, Method.POST, REST_PATH + run.getId(), Void.class);
            }
        }

    }

    /**
     * Request factories for "Sections".
     */
    @NoArgsConstructor
    public class Sections {

        /**
         * Returns an existing section.
         *
         * @param sectionId the ID of the section
         * @return the request
         * @throws java.lang.IllegalArgumentException if sectionId is not positive
         */
        public Get get(final int sectionId) {
            checkArgument(sectionId > 0, "sectionId should be positive");
            return new Get(sectionId);
        }

        /**
         * Returns a list of sections for a project.
         *
         * @param project the project which is operating in single suite mode
         * @return the request
         * @throws java.lang.NullPointerException if project is null
         */
        public List list(@NonNull Project project) {
            return new List(project, null);
        }

        /**
         * Returns a list of sections for a project and test suite.
         *
         * @param project the project
         * @param suite   the test suite
         * @return the request
         * @throws java.lang.NullPointerException if any argument is null
         */
        public List list(@NonNull Project project, @NonNull Suite suite) {
            return new List(project, suite);
        }

        /**
         * Creates a new section.
         *
         * @param project the project to add the section to
         * @param section the section to be added
         * @return the request
         * @throws java.lang.NullPointerException if any argument is null
         */
        public Add add(@NonNull Project project, @NonNull Section section) {
            return new Add(project, section);
        }

        /**
         * Updates an existing section. Partial updates are supported, i.e. you can set and update specific fields only.
         *
         * @param section the section to be updated
         * @return the request
         * @throws java.lang.NullPointerException if section is null
         */
        public Update update(@NonNull Section section) {
            return new Update(section);
        }

        /**
         * Deletes an existing section.
         *
         * @param section the section to be deleted
         * @return the request
         * @throws java.lang.NullPointerException if section is null
         */
        public Delete delete(@NonNull Section section) {
            return new Delete(section);
        }

        public class Get extends Request<Section> {
            private static final String REST_PATH = "get_section/";

            private Get(int sectionId) {
                super(config, Method.GET, REST_PATH + sectionId, Section.class);
            }

        }

        public class List extends Request<java.util.List<Section>> {
            private static final String REST_PATH = "get_sections/%s&suite_id=%s";

            private List(Project project, Suite suite) {
                super(config, Method.GET, String.format(REST_PATH, project.getId(), suite.getId()), new TypeReference<java.util.List<Section>>() {
                });
            }
        }

        public class Add extends Request<Section> {
            private static final String REST_PATH = "add_section/";

            private final Section section;

            private Add(Project project, Section section) {
                super(config, Method.POST, REST_PATH + project.getId(), Section.class);
                this.section = section;
            }

            @Override
            protected Object getContent() {
                return section;
            }
        }

        public class Update extends Request<Section> {
            private static final String REST_PATH = "update_section/";

            private final Section section;

            private Update(Section section) {
                super(config, Method.POST, REST_PATH + section.getId(), Section.class);
                this.section = section;
            }

            @Override
            protected Object getContent() {
                return section;
            }
        }

        public class Delete extends Request<Void> {
            private static final String REST_PATH = "delete_section/";

            private Delete(Section section) {
                super(config, Method.POST, REST_PATH + section.getId(), Void.class);
            }
        }
    }

    /**
     * Request factories for "Statuses".
     */
    @NoArgsConstructor
    public class Statuses {

        /**
         * Returns a list of available test statuses.
         *
         * @return the request
         */
        public List list() {
            return new List();
        }

        public class List extends Request<java.util.List<Status>> {
            private static final String REST_PATH = "get_statuses";

            private List() {
                super(config, Method.GET, REST_PATH, new TypeReference<java.util.List<Status>>() {
                });
            }
        }

    }

    /**
     * Request factories for "Suites".
     */
    @NoArgsConstructor
    public class Suites {

        /**
         * Returns an existing test suite.
         *
         * @param suiteId the ID of the test suite
         * @return the request
         * @throws java.lang.IllegalArgumentException if suiteId is not positive
         */
        public Get get(final int suiteId) {
            checkArgument(suiteId > 0, "suiteId should be positive");
            return new Get(suiteId);
        }

        /**
         * Returns a list of test suites for a project.
         *
         * @param project the project to get the test suites for
         * @return the request
         * @throws java.lang.NullPointerException if project is null
         */
        public List list(@NonNull Project project) {
            return new List(project);
        }

        /**
         * Creates a new test suite.
         *
         * @param suite the test suite to be added
         * @return the request
         * @throws java.lang.NullPointerException if suite is null
         */
        public Add add(@NonNull Suite suite) {
            return new Add(suite);
        }

        /**
         * Updates an existing test suite. Partial updates are supported, i.e. you can set and update specific fields only.
         *
         * @param suite the test suite to be updated
         * @return the request
         * @throws java.lang.NullPointerException if suite is null
         */
        public Update update(@NonNull Suite suite) {
            return new Update(suite);
        }

        /**
         * Deletes an existing test suite.
         *
         * @param suite the test suite to be deleted
         * @return the request
         * @throws java.lang.NullPointerException if suite is null
         */
        public Delete delete(@NonNull Suite suite) {
            return new Delete(suite);
        }

        public class Get extends Request<Suite> {
            private static final String REST_PATH = "get_suite/";

            private Get(int suiteId) {
                super(config, Method.GET, REST_PATH + suiteId, Suite.class);
            }
        }

        public class List extends Request<java.util.List<Suite>> {
            private static final String REST_PATH = "get_suites/";

            private List(Project project) {
                super(config, Method.GET, REST_PATH + project.getId(), new TypeReference<java.util.List<Suite>>() {
                });
            }
        }

        public class Add extends Request<Suite> {
            private static final String REST_PATH = "add_suite/";

            private final Suite suite;

            private Add(Suite suite) {
                super(config, Method.POST, REST_PATH + suite.getProjectId(), Suite.class);
                this.suite = suite;
            }

            @Override
            protected Object getContent() {
                return suite;
            }
        }

        public class Update extends Request<Suite> {
            private static final String REST_PATH = "update_suite/";

            private final Suite suite;

            private Update(Suite suite) {
                super(config, Method.POST, REST_PATH + suite.getId(), Suite.class);
                this.suite = suite;
            }

            @Override
            protected Object getContent() {
                return suite;
            }
        }

        public class Delete extends Request<Void> {
            private static final String REST_PATH = "delete_suite/";

            private Delete(Suite suite) {
                super(config, Method.POST, REST_PATH + suite.getId(), Void.class);
            }
        }

    }

    /**
     * Request factories for "Tests".
     */
    @NoArgsConstructor
    public class Tests {

        /**
         * Returns an existing test.
         *
         * @param testId the ID of the test
         * @return the request
         * @throws java.lang.IllegalArgumentException if testId is not positive
         */
        public Get get(final int testId) {
            checkArgument(testId > 0, "testId should be positive");
            return new Get(testId);
        }

        /**
         * Returns a list of tests for a test run.
         *
         * @param run the test run to get the tests for
         * @return the request
         * @throws java.lang.NullPointerException if run is null
         */
        public List list(@NonNull Run run) {
            return new List(run);
        }

        public class Get extends Request<Test> {
            private static final String REST_PATH = "get_test/";

            private Get(int testId) {
                super(config, Method.GET, REST_PATH + testId, Test.class);
            }
        }

        public class List extends Request<java.util.List<Test>> {
            private static final String REST_PATH = "get_tests/";

            private List(Run run) {
                super(config, Method.GET, REST_PATH + run.getId(), new TypeReference<java.util.List<Test>>() {
                });
            }
        }

    }

    /**
     * Request factories for "Users".
     */
    @NoArgsConstructor
    public class Users {

        /**
         * Returns an existing user.
         *
         * @param userId the ID of the user
         * @return the request
         * @throws java.lang.IllegalArgumentException if userId is not positive
         */
        public Get get(final int userId) {
            checkArgument(userId > 0, "userId should be positive");
            return new Get(userId);
        }

        /**
         * Returns an existing user by his/her email address.
         *
         * @param email the email address to get the user for
         * @return the request
         * @throws java.lang.NullPointerException     if email is null
         * @throws java.lang.IllegalArgumentException if email is empty
         */
        public GetByEmail getByEmail(@NonNull String email) {
            email = email.trim();
            checkArgument(!email.isEmpty(), "email cannot be empty");
            return new GetByEmail(email);
        }

        /**
         * Returns a list of users.
         *
         * @return the request
         */
        public List list() {
            return new List();
        }

        public class Get extends Request<User> {
            private static final String REST_PATH = "get_user/";

            private Get(int userId) {
                super(config, Method.GET, REST_PATH + userId, User.class);
            }
        }

        public class GetByEmail extends Request<User> {
            private static final String REST_PATH = "get_user_by_email&email=";

            private GetByEmail(String email) {
                super(config, Method.GET, REST_PATH + email, User.class);
            }
        }

        public class List extends Request<java.util.List<User>> {
            private static final String REST_PATH = "get_users";

            private List() {
                super(config, Method.GET, REST_PATH, new TypeReference<java.util.List<User>>() {
                });
            }
        }

    }
}