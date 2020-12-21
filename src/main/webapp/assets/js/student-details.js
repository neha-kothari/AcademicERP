const dataTable = $('#studentsTbl');

async function fetchStudentsGrades() {
    const course_id = sessionStorage.getItem('course_id');
    console.log(course_id);
    alert(course_id);
    let studentData;
    let response = await fetch("/api/courses/"+course_id+"/students").catch(err => {
        console.log(err)
    });
    studentData = await response.json(); // read response body and parse as JSON
    populateTable(studentData);
}

function populateTable(studentData) {
    dataTable.DataTable().clear();
    dataTable.DataTable().rows.add(studentData);
    dataTable.DataTable().draw();
    dataTable.css("display", "block");
}

function init() {
    dataTable.DataTable({
        data: [],
        columns: [
            {data: 'roll_number'},
            {data: 'full_name'},
            {data: 'grade_letter'},
            {data: 'grade_points'},
            {data: 'grade_points'},
            {data: 'cgpa'},
        ]
    });
    fetchStudentsGrades();
}


init();
