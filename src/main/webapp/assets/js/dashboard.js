const mockData = true;
const filterConfig = {
    'none': {
        label: 'No filter',
        fields: [],
        'submitApi': '/courses/all'
    },
    'year': {
        label: 'Year',
        fields: [
            {
                name: 'Year',
                populateApi: '/year/all'
            },
        ],
        'submitApi': '/courses/year/{0}'
    },
    'faculty': {
        label: 'Faculty',
        fields: [
            {
                name: 'Faculty',
                populateApi: '/faculty/all'
            },
        ],
        'submitApi': '/courses/faculty/{0}'
    },
    'capacity': {
        label: 'Capacity',
        fields: [
            {
                name: 'Capacity',
                populateApi: '/capacity/all'
            },
        ],
        'submitApi': '/courses/capacity/{0}'
    },
    'specialisation': {
        label: 'Specialisation',
        fields: [
            {
                name: 'Specialisation',
                populateApi: '/specialisation/all'
            },
        ],
        'submitApi': '/courses/specialisation/{0}'
    },
    'facultyAndSpecialisation': {
        label: 'Faculty and Specialisation',
        fields: [
            {
                name: 'Faculty',
                populateApi: '/faculty/all'
            },
            {
                name: 'Specialisation',
                populateApi: '/specialisation/all'
            },
        ],
        'submitApi': '/courses/faculty/{0}/specialisation/{1}'
    },
    'domainAndSpecialisation': {
        label: 'Domain and Specialisation',
        fields: [
            {
                name: 'Domain',
                populateApi: '/domain/all'
            },
            {
                name: 'Specialisation',
                populateApi: '/specialisation/all'
            },
        ],
        'submitApi': '/courses/domain/{0}/specialisation/{1}'
    },
    'yearAndTerm': {
        label: 'Year and Term',
        fields: [
            {
                name: 'Year',
                populateApi: '/year/all'
            },
            {
                name: 'Term',
                populateApi: '/term/all'
            },

        ],
        'submitApi': '/courses/year/{0}/term/{1}'
    },
};
const filterByDropdown = document.getElementById("filterBySelector");
const dataTable = $('#coursesTbl');


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
    let values;
    let response = await fetch(populateApi).catch(err => {
        console.log(err)
    });
    if (mockData) {
        values = ['a', 'b', 'c', 'd']
    } else {
        values = await response.json(); // read response body and parse as JSON
    }
    for (let i in values) {
        optionsAsString += `<option value='${values[i]}'>${values[i]}</option>`;
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
    if (mockData) {
        courseData = [
            {
                course_id: 'id1',
                name: 'Course 1',
                description: 'Description 1',
                credits: '1',
                term: 'Term 1',
                course_code: 'Code 1',
                year: '2021',
                capacity: '101',
                employee_id: '1,2,3,11',
                student_courses: '3,2,1,11',
                domains: 'D3, D2, D11',
                specialisations: 'S3, S2, S1'
            },
            {
                course_id: 'id2',
                name: 'Course 2',
                description: 'Description 2',
                credits: '2',
                term: 'Term 2',
                course_code: 'Code 2',
                year: '2022',
                capacity: '102',
                employee_id: '1,2,3,12',
                student_courses: '3,2,1,12',
                domains: 'D3, D2, D12',
                specialisations: 'S3, S2, S2'
            },
            {
                course_id: 'id3',
                name: 'Course 3',
                description: 'Description 3',
                credits: '3',
                term: 'Term 3',
                course_code: 'Code 3',
                year: '2023',
                capacity: '103',
                employee_id: '1,2,3,13',
                student_courses: '3,2,1,13',
                domains: 'D3, D2, D13',
                specialisations: 'S3, S2, S3'
            }
        ]
    } else {
        courseData = await response.json(); // read response body and parse as JSON
    }
    populateTable(courseData);
}

function populateTable(courseData) {
    dataTable.DataTable().clear();
    dataTable.DataTable().rows.add(courseData);
    dataTable.DataTable().draw();
    dataTable.css("display", "block");
}

function init() {
    dataTable.DataTable({
        data: [],
        columns: [
            {
                data: 'course_id',
                "render": function (data, type, row, meta) {
                    if (type === 'display') {
                        data = '<a href="/course/' + data + '/students">' + data + '</a>';
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
            {data: 'employee_id'},
            {data: 'student_courses'},
            {data: 'domains'},
            {data: 'specialisations'},
        ]
    });
    populateFilterOptions();
    showFilterFields();
}


init();
