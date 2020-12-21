const mockData = false;
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
                populateApi: 'api/faculty/all'
            },
        ],
        'submitApi': 'api/courses/faculty/{0}'
    },
    'capacity': {
        label: 'Capacity',
        fields: [
            {
                name: 'Capacity',
                populateApi: '/capacity/all'
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
                populateApi: 'api/specialisation/all'
            },
        ],
        'submitApi': 'api/courses/specialisation/{0}'
    },
    'facultyAndSpecialisation': {
        label: 'Faculty and Specialisation',
        fields: [
            {
                name: 'Faculty',
                populateApi: 'api/faculty/all'
            },
            {
                name: 'Specialisation',
                populateApi: 'api/specialisation/all'
            },
        ],
        'submitApi': 'api/courses/faculty/{0}/specialisation/{1}'
    },
    'domainAndSpecialisation': {
        label: 'Domain and Specialisation',
        fields: [
            {
                name: 'Domain',
                populateApi: 'api/domain/all'
            },
            {
                name: 'Specialisation',
                populateApi: 'api/specialisation/all'
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
        optionsAsString += `<option value='${values[i]['id']}'>${values[i]['label']}</option>`;
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
                faculty_name: '1,2,3,11',
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
                faculty_name: '1,2,3,12',
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
                faculty_name: '1,2,3,13',
                domains: 'D3, D2, D13',
                specialisations: 'S3, S2, S3'
            }
        ]
    } else {
        courseData = await response.json(); // read response body and parse as JSON
        console.dir(JSON.stringify(courseData));
    }
    populateTable(courseData);
}

function populateTable(courseData) {
    dataTable.DataTable().clear();
    dataTable.DataTable().rows.add(courseData);
    dataTable.DataTable().draw();
    datableContainer.show();
}

function init() {
    dataTable.DataTable({
        data: [],
        drawCallback: function () {
            this.api().columns().every( function () {
                var column = this;
                var select = $('<select><option value=""></option></select>')
                    .appendTo( $(column.footer()).empty() )
                    .on( 'change', function () {
                        var val = $.fn.dataTable.util.escapeRegex(
                            $(this).val()
                        );

                        column
                            .search( val ? '^'+val+'$' : '', true, false )
                            .draw();
                    } );

                column.data().unique().sort().each( function ( d, j ) {
                    select.append( '<option value="'+d+'">'+d+'</option>' )
                } );
            } );
        },
        columns: [
            {
                data: 'course_id',
                "render": function (data, type, row, meta) {
                    if (type === 'display') {
                        data = '<a href="/courses/' + data + '/students">' + data + '</a>';
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
    datableContainer.hide();
    populateFilterOptions();
    showFilterFields();
}


init();
