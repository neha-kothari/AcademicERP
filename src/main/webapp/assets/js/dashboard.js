const filterConfig = {
    'none': {
        label: 'No filter',
        fields: [],
        'submitApi': 'api/courses/all'
    },
    'year': {
        label: 'Year',
        fields: [
            {
                name: 'Year',
                populateApi: 'api/courses/years'
            },
        ],
        'submitApi': 'api/courses/year/{0}'
    },
    'faculty': {
        label: 'Faculty',
        fields: [
            {
                name: 'Faculty',
                populateApi: 'api/employee/options'
            },
        ],
        'submitApi': 'api/courses/faculty/{0}'
    },
    'capacity': {
        label: 'Capacity',
        fields: [
            {
                name: 'Capacity',
                populateApi: 'api/courses/capacity'
            },
        ],
        'submitApi': 'api/courses/capacity/{0}'
    },
    'domain': {
        label: 'Domain',
        fields: [
            {
                name: 'Domain',
                populateApi: 'api/domains/all'
            },
        ],
        'submitApi': 'api/courses/domain/{0}'
    },
    'specialisation': {
        label: 'Specialisation',
        fields: [
            {
                name: 'Specialisation',
                populateApi: 'api/specialisation/options'
            },
        ],
        'submitApi': 'api/courses/specialisation/{0}'
    },
    'facultyAndSpecialisation': {
        label: 'Faculty and Specialisation',
        fields: [
            {
                name: 'Faculty',
                populateApi: 'api/employee/options'
            },
            {
                name: 'Specialisation',
                populateApi: 'api/specialisation/options'
            },
        ],
        'submitApi': 'api/courses/faculty/{0}/specialisation/{1}'
    },
    'domainAndSpecialisation': {
        label: 'Domain and Specialisation',
        fields: [
            {
                name: 'Domain',
                populateApi: 'api/domains/all'
            },
            {
                name: 'Specialisation',
                populateApi: 'api/specialisation/options'
            },
        ],
        'submitApi': 'api/courses/domain/{0}/specialisation/{1}'
    },
    'yearAndTerm': {
        label: 'Year and Term',
        fields: [
            {
                name: 'Year',
                populateApi: 'api/courses/years'
            },
            {
                name: 'Term',
                populateApi: 'api/courses/terms'
            },

        ],
        'submitApi': 'api/courses/year/{0}/term/{1}'
    },
};
const filterByDropdown = document.getElementById("filterBySelector");
const dataTable = $('#coursesTbl');
const datableContainer = $('#data-table-container');
const studentTable = $('#studentsTbl');
function populateFilterOptions() {
    let optionsAsString = "";
    for (let filterKey in filterConfig) {
        optionsAsString += "<option value='" + filterKey + "'>" + filterConfig[filterKey].label + "</option>";
    }
    $('select[name="filterBySelector"]').append(optionsAsString);
}


function showFilterFields() {
    const config = filterConfig[filterByDropdown.value];

    let fieldsAsString = "";
    const dropdownFields = [];
    for (let fieldIndex in config.fields) {
        const fieldConfig = config.fields[fieldIndex];
        const dropdownField = `field-${fieldIndex}`;
        fieldsAsString += `<div class="col-md-5">
                                <label for="${dropdownField}">${fieldConfig.name}:</label>
                                <select id="${dropdownField}" name="${dropdownField}" class="form-control">
                                </select>
                            </div>`;
        dropdownFields.push(dropdownField);
    }
    $('#filter-fields-container').html(
        `${fieldsAsString}
        <div class="col-md-2">
            <button type="submit" class="btn btn-primary submit-filter" onclick="applyFilter('${config.submitApi}', '${dropdownFields.join(',') || null}')">Submit</button>
        </div>`
    );
    for (let fieldIndex in config.fields) {
        const fieldConfig = config.fields[fieldIndex];
        const dropdownField = `field-${fieldIndex}`;
        populateDropdown(dropdownField, fieldConfig.populateApi);
    }
};


async function populateDropdown(dropdownField, populateApi) {
    let optionsAsString = "";
    let response = await fetch(populateApi).catch(err => {
        console.log(err)
    });

    const values = await response.json(); // read response body and parse as JSON

    for (let i in values) {
        optionsAsString += `<option value='${values[i]['id']}'>${values[i]['label']}</option>`; ///WHAT IS LABEL
    }
    $(`select[name="${dropdownField}"]`).append(optionsAsString);
}


async function applyFilter(submitApi, dropdownFields) {
    if (dropdownFields && dropdownFields !== 'null') {
        dropdownFields = dropdownFields.split(',');
        for (let i in dropdownFields) {
            submitApi = submitApi.replace(`{${i}}`, $(`select[name="${dropdownFields[i]}"]`).val());
        }
    }
    let courseData;
    let response = await fetch(submitApi).catch(err => {
        console.log(err)
    });
    courseData = await response.json(); // read response body and parse as JSON
    populateTable(courseData);

}

function populateTable(courseData) {
    dataTable.DataTable().clear();
    dataTable.DataTable().rows.add(courseData);
    dataTable.DataTable().draw();
    datableContainer.show();
}

function callCourse(course_id){

    fetchStudentsGrades(course_id);
}

async function fetchStudentsGrades(course_id) {

    let studentData;
    let response = await fetch("api/courses/"+course_id+"/students").catch(err => {
        console.log(err)
    });
    studentData = await response.json(); // read response body and parse as JSON
    populateStudentTable(studentData);
}

function populateStudentTable(studentData) {
    studentTable.DataTable().clear();
    studentTable.DataTable().rows.add(studentData);
    studentTable.DataTable().draw();
}

function init() {
    dataTable.DataTable({
        data: [],
        columns: [
            {
                data: 'course_id',
                "render": function (data, type, row, meta) {
                    if (type === 'display') {
                        data = '<a data-toggle="modal" data-target="#gradeModal" onclick="callCourse('+data+')">'+ data + '</a>';
                    }

                    return data;
                }
            },
            {data: 'name'},
            {data: 'description'},
            {data: 'credits'},
            {data: 'term'},
            {data: 'course_code'},
            {data: 'year'},
            {data: 'capacity'},
            {data: 'faculty_name'},
            {data: 'domains'},
            {data: 'specialisations'},
        ]
    });

    studentTable.DataTable({
        data: [],
        columns: [
            {data: 'roll_number'},
            {data: 'full_name'},
            {data: 'grade_letter'},
            {data: 'grade_points'},
            {data: 'cgpa'},
        ]
    });

    datableContainer.hide();
    populateFilterOptions();
    showFilterFields();
}


init();
